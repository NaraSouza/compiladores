package br.ufpe.cin.if688.minijava;

import antlr.grammarMinijavaLexer;
import antlr.grammarMinijavaParser;
import br.ufpe.cin.if688.minijava.ast.Program;
import br.ufpe.cin.if688.minijava.visitor.MiniJavaVisitor;
import br.ufpe.cin.if688.minijava.visitor.PrettyPrintVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CharStream charStream = CharStreams.fromFileName("/home/nara/Documentos/UFPE/Compiladores/compiladores/atividade4/MiniJava-master (copy)/src/main/java/teste.txt");
        grammarMinijavaLexer lexer = new grammarMinijavaLexer(charStream);

        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        grammarMinijavaParser parser = new grammarMinijavaParser(commonTokenStream);

        MiniJavaVisitor miniJava = new MiniJavaVisitor();
        Program program = (Program) miniJava.visit(parser.goal());

        PrettyPrintVisitor printVisitor = new PrettyPrintVisitor();
        printVisitor.visit(program);
    }

}