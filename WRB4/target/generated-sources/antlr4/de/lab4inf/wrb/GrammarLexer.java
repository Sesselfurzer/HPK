// Generated from Grammar.g4 by ANTLR 4.7.1
package de.lab4inf.wrb;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		WS=10, LOG2=11, LN=12, LOG=13, SIN=14, ID=15, INTEGER=16, MUL=17, DIV=18, 
		ADD=19, SUB=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"WS", "LETTER", "DIGIT", "LOG2", "LN", "LOG", "SIN", "ID", "INTEGER", 
		"MUL", "DIV", "ADD", "SUB"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'e'", "';'", "'='", "'('", "','", "')'", "'^'", "'**'", 
		null, null, null, "'log'", "'sin'", null, null, "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "WS", "LOG2", 
		"LN", "LOG", "SIN", "ID", "INTEGER", "MUL", "DIV", "ADD", "SUB"
	};
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\6\13D\n"+
		"\13\r\13\16\13E\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16V\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17^\n\17\3\20\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22l\n\22\f\22"+
		"\16\22o\13\22\3\23\6\23r\n\23\r\23\16\23s\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31"+
		"\2\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26\3\2\5\4\2\13\13\"\"\4"+
		"\2C\\c|\3\2\62;\2\u0082\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5"+
		"\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2"+
		"\2\2\21=\3\2\2\2\23?\3\2\2\2\25C\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33U\3"+
		"\2\2\2\35]\3\2\2\2\37_\3\2\2\2!c\3\2\2\2#g\3\2\2\2%q\3\2\2\2\'u\3\2\2"+
		"\2)w\3\2\2\2+y\3\2\2\2-{\3\2\2\2/\60\7\60\2\2\60\4\3\2\2\2\61\62\7g\2"+
		"\2\62\6\3\2\2\2\63\64\7=\2\2\64\b\3\2\2\2\65\66\7?\2\2\66\n\3\2\2\2\67"+
		"8\7*\2\28\f\3\2\2\29:\7.\2\2:\16\3\2\2\2;<\7+\2\2<\20\3\2\2\2=>\7`\2\2"+
		">\22\3\2\2\2?@\7,\2\2@A\7,\2\2A\24\3\2\2\2BD\t\2\2\2CB\3\2\2\2DE\3\2\2"+
		"\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\b\13\2\2H\26\3\2\2\2IJ\t\3\2\2J\30"+
		"\3\2\2\2KL\t\4\2\2L\32\3\2\2\2MN\7n\2\2NO\7q\2\2OP\7i\2\2PV\7\64\2\2Q"+
		"R\7n\2\2RV\7f\2\2ST\7n\2\2TV\7d\2\2UM\3\2\2\2UQ\3\2\2\2US\3\2\2\2V\34"+
		"\3\2\2\2WX\7n\2\2X^\7p\2\2YZ\7n\2\2Z[\7q\2\2[\\\7i\2\2\\^\7G\2\2]W\3\2"+
		"\2\2]Y\3\2\2\2^\36\3\2\2\2_`\7n\2\2`a\7q\2\2ab\7i\2\2b \3\2\2\2cd\7u\2"+
		"\2de\7k\2\2ef\7p\2\2f\"\3\2\2\2gm\5\27\f\2hl\5\27\f\2il\5\31\r\2jl\7a"+
		"\2\2kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n$\3\2"+
		"\2\2om\3\2\2\2pr\5\31\r\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2t&\3"+
		"\2\2\2uv\7,\2\2v(\3\2\2\2wx\7\61\2\2x*\3\2\2\2yz\7-\2\2z,\3\2\2\2{|\7"+
		"/\2\2|.\3\2\2\2\t\2EU]kms\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}