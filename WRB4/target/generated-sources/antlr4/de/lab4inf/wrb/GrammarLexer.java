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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, WS=9, 
		ID=10, INTEGER=11, MUL=12, DIV=13, ADD=14, SUB=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "WS", 
		"LETTER", "DIGIT", "ID", "INTEGER", "MUL", "DIV", "ADD", "SUB"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "';'", "'='", "'('", "','", "')'", "'^'", "'**'", null, null, 
		null, "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "WS", "ID", "INTEGER", 
		"MUL", "DIV", "ADD", "SUB"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21Z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\n\6\n8\n\n\r\n\16\n9\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\7\rF\n"+
		"\r\f\r\16\rI\13\r\3\16\5\16L\n\16\3\16\6\16O\n\16\r\16\16\16P\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\2\27\2\31\f\33\r\35\16\37\17!\20#\21\3\2\5\4\2\13\13\"\"\4"+
		"\2C\\c|\3\2\62;\2]\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2"+
		"\2\2\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/\3\2\2\2\17\61\3"+
		"\2\2\2\21\63\3\2\2\2\23\67\3\2\2\2\25=\3\2\2\2\27?\3\2\2\2\31A\3\2\2\2"+
		"\33K\3\2\2\2\35R\3\2\2\2\37T\3\2\2\2!V\3\2\2\2#X\3\2\2\2%&\7\60\2\2&\4"+
		"\3\2\2\2\'(\7=\2\2(\6\3\2\2\2)*\7?\2\2*\b\3\2\2\2+,\7*\2\2,\n\3\2\2\2"+
		"-.\7.\2\2.\f\3\2\2\2/\60\7+\2\2\60\16\3\2\2\2\61\62\7`\2\2\62\20\3\2\2"+
		"\2\63\64\7,\2\2\64\65\7,\2\2\65\22\3\2\2\2\668\t\2\2\2\67\66\3\2\2\28"+
		"9\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\b\n\2\2<\24\3\2\2\2=>\t\3"+
		"\2\2>\26\3\2\2\2?@\t\4\2\2@\30\3\2\2\2AG\5\25\13\2BF\5\25\13\2CF\5\27"+
		"\f\2DF\7a\2\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2"+
		"\2\2H\32\3\2\2\2IG\3\2\2\2JL\7/\2\2KJ\3\2\2\2KL\3\2\2\2LN\3\2\2\2MO\5"+
		"\27\f\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\34\3\2\2\2RS\7,\2\2S"+
		"\36\3\2\2\2TU\7\61\2\2U \3\2\2\2VW\7-\2\2W\"\3\2\2\2XY\7/\2\2Y$\3\2\2"+
		"\2\b\29EGKP\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}