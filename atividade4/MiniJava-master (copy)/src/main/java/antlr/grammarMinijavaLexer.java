// Generated from /home/nara/Downloads/MiniJava-master (copy)/src/main/java/antlr/grammarMinijava.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class grammarMinijavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MainClass=1, ClassDeclarationv=2, VarDeclaration=3, MethodDeclaration=4, 
		Type=5, Statement=6, Expression=7, Expr=8, Identifier=9, INTEGER_LITERAL=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"MainClass", "ClassDeclarationv", "VarDeclaration", "MethodDeclaration", 
			"Type", "Statement", "Expression", "Expr", "Identifier", "INTEGER_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MainClass", "ClassDeclarationv", "VarDeclaration", "MethodDeclaration", 
			"Type", "Statement", "Expression", "Expr", "Identifier", "INTEGER_LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public grammarMinijavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "grammarMinijava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u016d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3Y\n\3\3\3"+
		"\3\3\7\3]\n\3\f\3\16\3`\13\3\3\3\7\3c\n\3\f\3\16\3f\13\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\7\5~\n\5\f\5\16\5\u0081\13\5\5\5\u0083\n\5\3\5\3\5\3\5\7\5\u0088"+
		"\n\5\f\5\16\5\u008b\13\5\3\5\7\5\u008e\n\5\f\5\16\5\u0091\13\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00af\n\6\3\7\3\7\7\7\u00b3\n\7"+
		"\f\7\16\7\u00b6\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00f7"+
		"\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u0132\n\b\3\t\3\t\3\t\5\t\u0137\n\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\7\t\u0150\n\t\f\t\16\t\u0153\13\t\5\t\u0155\n\t\3\t\3\t"+
		"\3\t\3\t\5\t\u015b\n\t\3\n\5\n\u015e\n\n\3\n\5\n\u0161\n\n\3\n\7\n\u0164"+
		"\n\n\f\n\16\n\u0167\13\n\3\13\6\13\u016a\n\13\r\13\16\13\u016b\2\2\f\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2\7\5\2,-//>>\5\2C\\aa"+
		"c|\5\2\62;C\\c|\3\2aa\3\2\62;\2\u018f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5H\3\2\2\2\7i\3\2\2\2\tm\3\2\2\2"+
		"\13\u00ae\3\2\2\2\r\u00f6\3\2\2\2\17\u0131\3\2\2\2\21\u015a\3\2\2\2\23"+
		"\u015d\3\2\2\2\25\u0169\3\2\2\2\27\30\7e\2\2\30\31\7n\2\2\31\32\7c\2\2"+
		"\32\33\7u\2\2\33\34\7u\2\2\34\35\3\2\2\2\35\36\5\23\n\2\36\37\7}\2\2\37"+
		" \7r\2\2 !\7w\2\2!\"\7d\2\2\"#\7n\2\2#$\7k\2\2$%\7e\2\2%&\3\2\2\2&\'\7"+
		"u\2\2\'(\7v\2\2()\7c\2\2)*\7v\2\2*+\7k\2\2+,\7e\2\2,-\3\2\2\2-.\7x\2\2"+
		"./\7q\2\2/\60\7k\2\2\60\61\7f\2\2\61\62\3\2\2\2\62\63\7o\2\2\63\64\7c"+
		"\2\2\64\65\7k\2\2\65\66\7p\2\2\66\67\3\2\2\2\678\7*\2\289\7U\2\29:\7v"+
		"\2\2:;\7t\2\2;<\7k\2\2<=\7p\2\2=>\7i\2\2>?\3\2\2\2?@\7]\2\2@A\7_\2\2A"+
		"B\5\23\n\2BC\7+\2\2CD\7}\2\2DE\5\r\7\2EF\7\177\2\2FG\7\177\2\2G\4\3\2"+
		"\2\2HI\7e\2\2IJ\7n\2\2JK\7c\2\2KL\7u\2\2LM\7u\2\2MN\3\2\2\2NX\5\23\n\2"+
		"OP\7g\2\2PQ\7z\2\2QR\7v\2\2RS\7g\2\2ST\7p\2\2TU\7f\2\2UV\7u\2\2VW\3\2"+
		"\2\2WY\5\23\n\2XO\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z^\7}\2\2[]\5\7\4\2\\[\3"+
		"\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_d\3\2\2\2`^\3\2\2\2ac\5\t\5\2ba"+
		"\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\177\2\2"+
		"h\6\3\2\2\2ij\5\13\6\2jk\5\23\n\2kl\7=\2\2l\b\3\2\2\2mn\7r\2\2no\7w\2"+
		"\2op\7d\2\2pq\7n\2\2qr\7k\2\2rs\7e\2\2st\3\2\2\2tu\5\13\6\2uv\5\23\n\2"+
		"v\u0082\7*\2\2wx\5\13\6\2x\177\5\23\n\2yz\7.\2\2z{\5\13\6\2{|\5\23\n\2"+
		"|~\3\2\2\2}y\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082w\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\7+\2\2\u0085\u0089\7}\2\2\u0086\u0088\5\7\4"+
		"\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008f\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u008e\5\r\7\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7t\2\2\u0093"+
		"\u0094\7g\2\2\u0094\u0095\7v\2\2\u0095\u0096\7w\2\2\u0096\u0097\7t\2\2"+
		"\u0097\u0098\7p\2\2\u0098\u0099\3\2\2\2\u0099\u009a\5\17\b\2\u009a\u009b"+
		"\7=\2\2\u009b\u009c\7\177\2\2\u009c\n\3\2\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7p\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7]\2"+
		"\2\u00a2\u00af\7_\2\2\u00a3\u00a4\7d\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6"+
		"\7q\2\2\u00a6\u00a7\7n\2\2\u00a7\u00a8\7g\2\2\u00a8\u00a9\7c\2\2\u00a9"+
		"\u00af\7p\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7p\2\2\u00ac\u00af\7v\2\2"+
		"\u00ad\u00af\5\23\n\2\u00ae\u009d\3\2\2\2\u00ae\u00a3\3\2\2\2\u00ae\u00aa"+
		"\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\f\3\2\2\2\u00b0\u00b4\7}\2\2\u00b1"+
		"\u00b3\5\r\7\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00f7\7\177\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7h\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bc\7*\2\2\u00bc\u00bd\5\17\b\2\u00bd\u00be\7+\2\2\u00be"+
		"\u00bf\5\r\7\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2\7u\2"+
		"\2\u00c2\u00c3\7g\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\5\r\7\2\u00c5\u00f7"+
		"\3\2\2\2\u00c6\u00c7\7y\2\2\u00c7\u00c8\7j\2\2\u00c8\u00c9\7k\2\2\u00c9"+
		"\u00ca\7n\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\7*\2"+
		"\2\u00cd\u00ce\5\17\b\2\u00ce\u00cf\7+\2\2\u00cf\u00d0\5\r\7\2\u00d0\u00f7"+
		"\3\2\2\2\u00d1\u00d2\7U\2\2\u00d2\u00d3\7{\2\2\u00d3\u00d4\7u\2\2\u00d4"+
		"\u00d5\7v\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7o\2\2\u00d7\u00d8\7\60\2"+
		"\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7w\2\2\u00da\u00db\7v\2\2\u00db\u00dc"+
		"\7\60\2\2\u00dc\u00dd\7r\2\2\u00dd\u00de\7t\2\2\u00de\u00df\7k\2\2\u00df"+
		"\u00e0\7p\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7p\2\2"+
		"\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7*\2\2\u00e5\u00e6\5\17\b\2\u00e6\u00e7"+
		"\7+\2\2\u00e7\u00e8\7=\2\2\u00e8\u00f7\3\2\2\2\u00e9\u00ea\5\23\n\2\u00ea"+
		"\u00eb\7?\2\2\u00eb\u00ec\5\17\b\2\u00ec\u00ed\7=\2\2\u00ed\u00f7\3\2"+
		"\2\2\u00ee\u00ef\5\23\n\2\u00ef\u00f0\7]\2\2\u00f0\u00f1\5\17\b\2\u00f1"+
		"\u00f2\7_\2\2\u00f2\u00f3\7?\2\2\u00f3\u00f4\5\17\b\2\u00f4\u00f5\7=\2"+
		"\2\u00f5\u00f7\3\2\2\2\u00f6\u00b0\3\2\2\2\u00f6\u00b8\3\2\2\2\u00f6\u00c6"+
		"\3\2\2\2\u00f6\u00d1\3\2\2\2\u00f6\u00e9\3\2\2\2\u00f6\u00ee\3\2\2\2\u00f7"+
		"\16\3\2\2\2\u00f8\u0132\5\21\t\2\u00f9\u00fa\5\25\13\2\u00fa\u00fb\5\21"+
		"\t\2\u00fb\u0132\3\2\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7t\2\2\u00fe\u00ff"+
		"\7w\2\2\u00ff\u0100\7g\2\2\u0100\u0101\3\2\2\2\u0101\u0132\5\21\t\2\u0102"+
		"\u0103\7h\2\2\u0103\u0104\7c\2\2\u0104\u0105\7n\2\2\u0105\u0106\7u\2\2"+
		"\u0106\u0107\7g\2\2\u0107\u0108\3\2\2\2\u0108\u0132\5\21\t\2\u0109\u010a"+
		"\5\23\n\2\u010a\u010b\5\21\t\2\u010b\u0132\3\2\2\2\u010c\u010d\7v\2\2"+
		"\u010d\u010e\7j\2\2\u010e\u010f\7k\2\2\u010f\u0110\7u\2\2\u0110\u0111"+
		"\3\2\2\2\u0111\u0132\5\21\t\2\u0112\u0113\7p\2\2\u0113\u0114\7g\2\2\u0114"+
		"\u0115\7y\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7k\2\2\u0117\u0118\7p\2"+
		"\2\u0118\u0119\7v\2\2\u0119\u011a\3\2\2\2\u011a\u011b\7]\2\2\u011b\u011c"+
		"\5\17\b\2\u011c\u011d\7_\2\2\u011d\u011e\5\21\t\2\u011e\u0132\3\2\2\2"+
		"\u011f\u0120\7p\2\2\u0120\u0121\7g\2\2\u0121\u0122\7y\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0124\5\23\n\2\u0124\u0125\7*\2\2\u0125\u0126\7+\2\2\u0126"+
		"\u0127\5\21\t\2\u0127\u0132\3\2\2\2\u0128\u0129\7#\2\2\u0129\u012a\5\17"+
		"\b\2\u012a\u012b\5\21\t\2\u012b\u0132\3\2\2\2\u012c\u012d\7*\2\2\u012d"+
		"\u012e\5\17\b\2\u012e\u012f\7+\2\2\u012f\u0130\5\21\t\2\u0130\u0132\3"+
		"\2\2\2\u0131\u00f8\3\2\2\2\u0131\u00f9\3\2\2\2\u0131\u00fc\3\2\2\2\u0131"+
		"\u0102\3\2\2\2\u0131\u0109\3\2\2\2\u0131\u010c\3\2\2\2\u0131\u0112\3\2"+
		"\2\2\u0131\u011f\3\2\2\2\u0131\u0128\3\2\2\2\u0131\u012c\3\2\2\2\u0132"+
		"\20\3\2\2\2\u0133\u0134\7(\2\2\u0134\u0137\7(\2\2\u0135\u0137\t\2\2\2"+
		"\u0136\u0133\3\2\2\2\u0136\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139"+
		"\5\17\b\2\u0139\u013a\5\21\t\2\u013a\u015b\3\2\2\2\u013b\u013c\7]\2\2"+
		"\u013c\u013d\5\17\b\2\u013d\u013e\7_\2\2\u013e\u013f\5\21\t\2\u013f\u015b"+
		"\3\2\2\2\u0140\u0141\7\60\2\2\u0141\u0142\7n\2\2\u0142\u0143\7g\2\2\u0143"+
		"\u0144\7p\2\2\u0144\u0145\7i\2\2\u0145\u0146\7v\2\2\u0146\u0147\7j\2\2"+
		"\u0147\u0148\3\2\2\2\u0148\u015b\5\21\t\2\u0149\u014a\7\60\2\2\u014a\u014b"+
		"\5\23\n\2\u014b\u0154\7*\2\2\u014c\u0151\5\17\b\2\u014d\u014e\7.\2\2\u014e"+
		"\u0150\5\17\b\2\u014f\u014d\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3"+
		"\2\2\2\u0151\u0152\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u014c\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\7+"+
		"\2\2\u0157\u0158\5\21\t\2\u0158\u015b\3\2\2\2\u0159\u015b\3\2\2\2\u015a"+
		"\u0136\3\2\2\2\u015a\u013b\3\2\2\2\u015a\u0140\3\2\2\2\u015a\u0149\3\2"+
		"\2\2\u015a\u0159\3\2\2\2\u015b\22\3\2\2\2\u015c\u015e\t\3\2\2\u015d\u015c"+
		"\3\2\2\2\u015e\u0165\3\2\2\2\u015f\u0161\t\4\2\2\u0160\u015f\3\2\2\2\u0161"+
		"\u0164\3\2\2\2\u0162\u0164\t\5\2\2\u0163\u0160\3\2\2\2\u0163\u0162\3\2"+
		"\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\24\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u016a\t\6\2\2\u0169\u0168\3\2\2"+
		"\2\u016a\u016b\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\26"+
		"\3\2\2\2\27\2X^d\177\u0082\u0089\u008f\u00ae\u00b4\u00f6\u0131\u0136\u0151"+
		"\u0154\u015a\u015d\u0160\u0163\u0165\u016b\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}