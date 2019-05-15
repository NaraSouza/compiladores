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
        return null;
    }

    @Override
    public Object visitMainClass(grammarMinijavaParser.MainClassContext ctx) {
        return null;
    }

    @Override
    public Object visitClassDeclaration(grammarMinijavaParser.ClassDeclarationContext ctx) {
        return null;
    }

    @Override
    public Object visitVarDeclaration(grammarMinijavaParser.VarDeclarationContext ctx) {
        return null;
    }

    @Override
    public Object visitMethodDeclaration(grammarMinijavaParser.MethodDeclarationContext ctx) {
        return null;
    }

    @Override
    public Object visitType(grammarMinijavaParser.TypeContext ctx) {
        return null;
    }

    @Override
    public Object visitStatement(grammarMinijavaParser.StatementContext ctx) {
        return null;
    }

    @Override
    public Object visitExpression(grammarMinijavaParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return null;
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
