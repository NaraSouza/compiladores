package br.ufpe.cin.if688.minijava.visitor;

import antlr.grammarMinijavaParser;
import antlr.grammarMinijavaVisitor;
import br.ufpe.cin.if688.minijava.ast.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MiniJavaVisitor implements grammarMinijavaVisitor {

    @Override
    public Program visitGoal(grammarMinijavaParser.GoalContext ctx) {
        MainClass mainClass = (MainClass) ctx.mainClass().accept(this);
        ClassDeclList declList = new ClassDeclList();

        for(grammarMinijavaParser.ClassDeclarationContext c : ctx.classDeclaration()) {
            declList.addElement((ClassDecl) c.accept(this));
        }

        return new Program(mainClass, declList);
    }

    @Override
    public Object visitMainClass(grammarMinijavaParser.MainClassContext ctx) {
        Identifier i1 = (Identifier) ctx.identifier(0).accept(this);
        Identifier i2 = (Identifier) ctx.identifier(1).accept(this);
        Statement s = (Statement) ctx.statement().accept(this);

        return new MainClass(i1, i2, s);
    }

    @Override
    public Object visitClassDeclaration(grammarMinijavaParser.ClassDeclarationContext ctx) {
        VarDeclList varDeclList= new VarDeclList();
        for(grammarMinijavaParser.VarDeclarationContext v : ctx.varDeclaration()) {
            varDeclList.addElement((VarDecl) v.accept(this));
        }

        MethodDeclList methodDeclList = new MethodDeclList();
        for(grammarMinijavaParser.MethodDeclarationContext m : ctx.methodDeclaration()) {
            methodDeclList.addElement((MethodDecl) m.accept(this));
        }

        Identifier i1 = (Identifier) ctx.identifier(0).accept(this);
        if(ctx.identifier().size() > 1) {
            Identifier i2 = (Identifier) ctx.identifier(1).accept(this);
            return new ClassDeclExtends(i1, i2, varDeclList, methodDeclList);
        }

        return new ClassDeclSimple(i1, varDeclList, methodDeclList);
    }

    @Override
    public Object visitVarDeclaration(grammarMinijavaParser.VarDeclarationContext ctx) {
        Type t = (Type) ctx.type().accept(this);
        Identifier i = (Identifier) ctx.identifier().accept(this);

        return new VarDecl(t, i);
    }

    @Override
    public Object visitMethodDeclaration(grammarMinijavaParser.MethodDeclarationContext ctx) {
        Type t = (Type) ctx.type(0).accept(this);
        Identifier i = (Identifier) ctx.identifier(0).accept(this);

        FormalList formalList = new FormalList();
        for (int j = 1; j < ctx.type().size(); j++) {
            Formal f = new Formal((Type) ctx.type(j).accept(this), (Identifier) ctx.identifier(j).accept(this));
            formalList.addElement(f);
        }

        VarDeclList varDeclList = new VarDeclList();
        for (grammarMinijavaParser.VarDeclarationContext vc : ctx.varDeclaration()) {
            VarDecl v = (VarDecl) vc.accept(this);
            varDeclList.addElement(v);
        }

        StatementList statementList = new StatementList();
        for (grammarMinijavaParser.StatementContext sc : ctx.statement()) {
            Statement s = (Statement) sc.accept(this);
            statementList.addElement(s);
        }

        Exp e = (Exp) ctx.expression().accept(this);

        return new MethodDecl(t, i, formalList, varDeclList, statementList, e);
    }

    @Override
    public Object visitType(grammarMinijavaParser.TypeContext ctx) {
        String type = ctx.getText();
        if(type.equals("int []")) {
            return new IntArrayType();
        } else if(type.equals("boolean")) {
            return new BooleanType();
        } else if(type.equals("int")) {
            return new IntegerType();
        } else {
            return new IdentifierType(type);
        }
    }

    @Override
    public Object visitStatement(grammarMinijavaParser.StatementContext ctx) {
        String str = ctx.getStart().getText();
        if ("{".equals(str)) {
            StatementList statementList = new StatementList();
            for (grammarMinijavaParser.StatementContext s : ctx.statement()) {
                Statement stm = (Statement) s.accept(this);
                statementList.addElement(stm);
            }

            return new Block(statementList);

        } else if ("if".equals(str)) {
            Exp e = (Exp) ctx.expression(0).accept(this);
            Statement s1 = (Statement) ctx.statement(0).accept(this);
            Statement s2 = (Statement) ctx.statement(1).accept(this);

            return new If(e, s1, s2);

        } else if ("System.out.println".equals(str)) {
            Exp e = (Exp) ctx.expression(0).accept(this);

            return new Print(e);

        } else if ("while".equals(str)) {
            Exp e = (Exp) ctx.expression(0).accept(this);
            Statement s1 = (Statement) ctx.statement(0).accept(this);

            return new While(e, s1);

        } else {
            if (ctx.expression().size() > 1) {
                Identifier i = (Identifier) ctx.identifier().accept(this);
                Exp e1 = (Exp) ctx.expression(0).accept(this);
                Exp e2 = (Exp) ctx.expression(1).accept(this);

                return new ArrayAssign(i, e1, e2);

            } else {
                Identifier i = (Identifier) ctx.identifier().accept(this);
                Exp e = (Exp) ctx.expression(0).accept(this);

                return new Assign(i, e);
            }
        }
    }

    @Override
    public Object visitExpression(grammarMinijavaParser.ExpressionContext ctx) {
        int exprSize = ctx.expression().size();

        if (exprSize == 0) {
            if(ctx.integer_literal() != null) {
                return new IntegerLiteral(((IntegerLiteral)(ctx.integer_literal().accept(this))).i);
            }

            if(ctx.identifier() != null) {
                if(ctx.getText().contains("new")) {
                    return new NewObject((Identifier) ctx.identifier().accept(this));
                } else {
                    return new IdentifierExp(ctx.getText());
                }
            }

            String text = ctx.getText();

            if (text.equals("true")) {
                return new True();
            } else if (text.equals("false")) {
                return new False();
            } else {
                return new This();
            }

        } else if (exprSize == 1) {
            String text = ctx.getText();
            Exp e = (Exp) ctx.expression(0).accept(this);


            if (text.contains("length")) {
                return new ArrayLength(e);
            } else if (text.contains("new")) {
                return new NewArray(e);
            } else if (text.equals("!")) {
                return new Not(e);
            } else {
                return e;
            }

        } else if (exprSize == 2) {
            Exp expr1 = (Exp) ctx.expression(0).accept(this);
            Exp expr2 = (Exp) ctx.expression(1).accept(this);

            if (ctx.getText().contains("[")) {
                return new ArrayLookup(expr1, expr2);
            } else {
                if (ctx.getText().contains("&&")) {
                    return new And(expr1, expr2);
                } else if (ctx.getText().contains("+")) {
                    return new Plus(expr1, expr2);
                } else if (ctx.getText().contains("-")) {
                    return new Minus(expr1, expr2);
                } else if (ctx.getText().contains("<")) {
                    return new LessThan(expr1, expr2);
                } else{
                    return new Times(expr1, expr2);
                }
            }

        } else {
            Exp e = (Exp) ctx.expression(0).accept(this);
            Identifier i = (Identifier) ctx.identifier().accept(this);

            ExpList expList = new ExpList();
            for (int j = 1; j < ctx.expression().size(); j++) {
                expList.addElement((Exp) ctx.expression(j).accept(this));
            }
            return new Call(e, i, expList);
        }
    }

    @Override
    public Object visitIdentifier(grammarMinijavaParser.IdentifierContext ctx) {
        return new Identifier(ctx.getText());
    }

    @Override
    public Object visitInteger_literal(grammarMinijavaParser.Integer_literalContext ctx) {
        return new IntegerLiteral(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return parseTree.accept(this);
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}