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
        ctx.mainClass().accept(this);

        for(grammarMinijavaParser.ClassDeclarationContext c : ctx.classDeclaration()) {
            c.accept(this);
        }

        return (Program) ctx.accept(this);
    }

    @Override
    public Object visitMainClass(grammarMinijavaParser.MainClassContext ctx) {
        ctx.identifier(0).accept(this);
        ctx.identifier(1).accept(this);
        ctx.statement().accept(this);

        return ctx.accept(this);
    }

    @Override
    public Object visitClassDeclaration(grammarMinijavaParser.ClassDeclarationContext ctx) {
        ctx.identifier(0).accept(this);
        if(ctx.identifier().size() > 1) {
            ctx.identifier(1).accept(this);
        }

        for(grammarMinijavaParser.VarDeclarationContext v : ctx.varDeclaration()) {
            v.accept(this);
        }

        for(grammarMinijavaParser.MethodDeclarationContext m : ctx.methodDeclaration()) {
            m.accept(this);
        }

        return ctx.accept(this);
    }

    @Override
    public Object visitVarDeclaration(grammarMinijavaParser.VarDeclarationContext ctx) {
        ctx.type().accept(this);
        ctx.identifier().accept(this);

        return ctx.accept(this);
    }

    @Override
    public Object visitMethodDeclaration(grammarMinijavaParser.MethodDeclarationContext ctx) {
        for(grammarMinijavaParser.TypeContext t : ctx.type()) {
            t.accept(this);
        }

        for(grammarMinijavaParser.IdentifierContext i : ctx.identifier()) {
            i.accept(this);
        }

        for(grammarMinijavaParser.VarDeclarationContext v : ctx.varDeclaration()) {
            v.accept(this);
        }

        for(grammarMinijavaParser.StatementContext s : ctx.statement()) {
            s.accept(this);
        }

        ctx.expression().accept(this);

        return ctx.accept(this);
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
        }

        return ctx.identifier().accept(this);
    }

    @Override
    public Object visitStatement(grammarMinijavaParser.StatementContext ctx) {
        for(grammarMinijavaParser.StatementContext s : ctx.statement()) {
            s.accept(this);
        }

        for(grammarMinijavaParser.ExpressionContext e : ctx.expression()) {
            e.accept(this);
        }

        //ctx.identifier().accept(this);

        return ctx.accept(this);
    }

    @Override
    public Object visitExpression(grammarMinijavaParser.ExpressionContext ctx) {
        int exprSize = ctx.expression().size();

        if (exprSize == 0) {
            if(ctx.integer_literal() != null) {
                return new IntegerLiteral(((IntegerLiteral)(ctx.integer_literal().accept(this))).i);
            }

            if(ctx.identifier() != null) {
                if(ctx.getText() != null) {
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
