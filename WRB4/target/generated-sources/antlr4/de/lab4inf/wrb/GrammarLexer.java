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
		WS=10, LOG2=11, LN=12, LOG=13, ID=14, INTEGER=15, MUL=16, DIV=17, ADD=18, 
		SUB=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"WS", "LETTER", "DIGIT", "LOG2", "LN", "LOG", "ID", "INTEGER", "MUL", 
		"DIV", "ADD", "SUB"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'e'", "';'", "'='", "'('", "','", "')'", "'^'", "'**'", 
		null, null, null, "'log'", null, null, "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "WS", "LOG2", 
		"LN", "LOG", "ID", "INTEGER", "MUL", "DIV", "ADD", "SUB"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25w\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\6\13B\n\13\r\13\16"+
		"\13C\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16T\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\\\n\17\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\7\21f\n\21\f\21\16\21i\13\21\3\22\6\22l\n\22\r"+
		"\22\16\22m\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\2\2\27\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\r\35\16\37\17!\20#\21"+
		"%\22\'\23)\24+\25\3\2\5\4\2\13\13\"\"\4\2C\\c|\3\2\62;\2|\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t\63\3\2\2\2\13\65\3\2"+
		"\2\2\r\67\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25A\3\2\2\2\27G"+
		"\3\2\2\2\31I\3\2\2\2\33S\3\2\2\2\35[\3\2\2\2\37]\3\2\2\2!a\3\2\2\2#k\3"+
		"\2\2\2%o\3\2\2\2\'q\3\2\2\2)s\3\2\2\2+u\3\2\2\2-.\7\60\2\2.\4\3\2\2\2"+
		"/\60\7g\2\2\60\6\3\2\2\2\61\62\7=\2\2\62\b\3\2\2\2\63\64\7?\2\2\64\n\3"+
		"\2\2\2\65\66\7*\2\2\66\f\3\2\2\2\678\7.\2\28\16\3\2\2\29:\7+\2\2:\20\3"+
		"\2\2\2;<\7`\2\2<\22\3\2\2\2=>\7,\2\2>?\7,\2\2?\24\3\2\2\2@B\t\2\2\2A@"+
		"\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\b\13\2\2F\26\3\2\2"+
		"\2GH\t\3\2\2H\30\3\2\2\2IJ\t\4\2\2J\32\3\2\2\2KL\7n\2\2LM\7q\2\2MN\7i"+
		"\2\2NT\7\64\2\2OP\7n\2\2PT\7f\2\2QR\7n\2\2RT\7d\2\2SK\3\2\2\2SO\3\2\2"+
		"\2SQ\3\2\2\2T\34\3\2\2\2UV\7n\2\2V\\\7p\2\2WX\7n\2\2XY\7q\2\2YZ\7i\2\2"+
		"Z\\\7G\2\2[U\3\2\2\2[W\3\2\2\2\\\36\3\2\2\2]^\7n\2\2^_\7q\2\2_`\7i\2\2"+
		"` \3\2\2\2ag\5\27\f\2bf\5\27\f\2cf\5\31\r\2df\7a\2\2eb\3\2\2\2ec\3\2\2"+
		"\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\"\3\2\2\2ig\3\2\2\2jl\5\31"+
		"\r\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n$\3\2\2\2op\7,\2\2p&\3\2"+
		"\2\2qr\7\61\2\2r(\3\2\2\2st\7-\2\2t*\3\2\2\2uv\7/\2\2v,\3\2\2\2\t\2CS"+
		"[egm\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}