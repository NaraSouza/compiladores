package br.ufpe.cin.if688.minijava.visitor;

import antlr.grammarMinijavaParser;
import antlr.grammarMinijavaVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class MiniJavaVisitor implements grammarMinijavaVisitor {

    @Override
    public Object visitGoal(grammarMinijavaParser.GoalContext ctx) {
        return ctx.mainClass().accept(this);
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

        ctx.identifier().accept(this);

        return ctx.accept(this);
    }

    @Override
    public Object visitExpression(grammarMinijavaParser.ExpressionContext ctx) {
        for(grammarMinijavaParser.ExpressionContext e : ctx.expression()) {
            e.accept(this);
        }

        ctx.identifier().accept(this);

        ctx.integer_literal().accept(this);

        return ctx.accept(this);
    }

    @Override
    public Object visitIdentifier(grammarMinijavaParser.IdentifierContext ctx) {
        return ctx.Identifier().accept(this);
    }

    @Override
    public Object visitInteger_literal(grammarMinijavaParser.Integer_literalContext ctx) {
        return ctx.Integer_literal().accept(this);
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
