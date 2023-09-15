// Generated from C:/Users/abc/Desktop/compbau/spl/src\SPL.g4 by ANTLR 4.12.0
package spl.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SPLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, KW_TRUE=2, KW_FALSE=3, KW_VAR=4, KW_PRINT=5, KW_IF=6, KW_ELSE=7, 
		KW_WHILE=8, KW_RETURN=9, KW_FUNC=10, KW_NUMBER=11, KW_BOOL=12, KW_STRING=13, 
		KW_ANY=14, KW_LIST=15, MUL=16, DIV=17, ADD=18, SUB=19, NEQ=20, GTE=21, 
		LTE=22, GT=23, LT=24, EQ=25, NOT=26, AND=27, OR=28, ASSIGN=29, LPAREN=30, 
		RPAREN=31, LCURLY=32, RCURLY=33, LSQUARE=34, RSQUARE=35, SEMICOLON=36, 
		COLON=37, COMMA=38, STRING=39, NUMBER=40, IDENTIFIER=41, WS=42;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_declartionList = 2, RULE_varDecl = 3, 
		RULE_boundedIdent = 4, RULE_type = 5, RULE_statement = 6, RULE_exprStmt = 7, 
		RULE_ifStmt = 8, RULE_printStmt = 9, RULE_returnStmt = 10, RULE_whileStmt = 11, 
		RULE_block = 12, RULE_expression = 13, RULE_expressionList = 14, RULE_assignment = 15, 
		RULE_term = 16, RULE_primary = 17, RULE_paramList = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "declartionList", "varDecl", "boundedIdent", 
			"type", "statement", "exprStmt", "ifStmt", "printStmt", "returnStmt", 
			"whileStmt", "block", "expression", "expressionList", "assignment", "term", 
			"primary", "paramList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'true'", "'false'", "'var'", "'print'", "'if'", "'else'", 
			"'while'", "'return'", "'func'", "'number'", "'bool'", "'string'", "'any'", 
			"'list'", "'*'", "'/'", "'+'", "'-'", "'!='", "'>='", "'<='", "'>'", 
			"'<'", "'=='", "'!'", "'and'", "'or'", "'='", "'('", "')'", "'{'", "'}'", 
			"'['", "']'", "';'", "':'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "KW_TRUE", "KW_FALSE", "KW_VAR", "KW_PRINT", "KW_IF", 
			"KW_ELSE", "KW_WHILE", "KW_RETURN", "KW_FUNC", "KW_NUMBER", "KW_BOOL", 
			"KW_STRING", "KW_ANY", "KW_LIST", "MUL", "DIV", "ADD", "SUB", "NEQ", 
			"GTE", "LTE", "GT", "LT", "EQ", "NOT", "AND", "OR", "ASSIGN", "LPAREN", 
			"RPAREN", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", "SEMICOLON", "COLON", 
			"COMMA", "STRING", "NUMBER", "IDENTIFIER", "WS"
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

	@Override
	public String getGrammarFileName() { return "SPL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SPLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DeclartionListContext declartionList() {
			return getRuleContext(DeclartionListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SPLParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			declartionList();
			setState(39);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				varDecl();
				}
				break;
			case KW_TRUE:
			case KW_FALSE:
			case KW_PRINT:
			case KW_IF:
			case KW_WHILE:
			case KW_RETURN:
			case KW_FUNC:
			case SUB:
			case NOT:
			case LPAREN:
			case LCURLY:
			case LSQUARE:
			case STRING:
			case NUMBER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclartionListContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclartionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declartionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterDeclartionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitDeclartionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitDeclartionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclartionListContext declartionList() throws RecognitionException {
		DeclartionListContext _localctx = new DeclartionListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declartionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3870906910588L) != 0)) {
				{
				{
				setState(45);
				declaration();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	 
		public VarDeclContext() { }
		public void copyFrom(VarDeclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleVarDeclContext extends VarDeclContext {
		public Token ident;
		public TerminalNode KW_VAR() { return getToken(SPLParser.KW_VAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(SPLParser.SEMICOLON, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SPLParser.IDENTIFIER, 0); }
		public SimpleVarDeclContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterSimpleVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitSimpleVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitSimpleVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclAndAssignContext extends VarDeclContext {
		public TerminalNode KW_VAR() { return getToken(SPLParser.KW_VAR, 0); }
		public BoundedIdentContext boundedIdent() {
			return getRuleContext(BoundedIdentContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(SPLParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SPLParser.SEMICOLON, 0); }
		public VarDeclAndAssignContext(VarDeclContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterVarDeclAndAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitVarDeclAndAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitVarDeclAndAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDeclAndAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(KW_VAR);
				setState(52);
				boundedIdent();
				setState(53);
				match(ASSIGN);
				setState(54);
				expression();
				setState(55);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new SimpleVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(KW_VAR);
				setState(58);
				((SimpleVarDeclContext)_localctx).ident = match(IDENTIFIER);
				setState(59);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoundedIdentContext extends ParserRuleContext {
		public Token ident;
		public TypeContext bound;
		public TerminalNode IDENTIFIER() { return getToken(SPLParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(SPLParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public BoundedIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundedIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterBoundedIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitBoundedIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitBoundedIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundedIdentContext boundedIdent() throws RecognitionException {
		BoundedIdentContext _localctx = new BoundedIdentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_boundedIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			((BoundedIdentContext)_localctx).ident = match(IDENTIFIER);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(63);
				match(COLON);
				setState(64);
				((BoundedIdentContext)_localctx).bound = type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode KW_ANY() { return getToken(SPLParser.KW_ANY, 0); }
		public TerminalNode KW_BOOL() { return getToken(SPLParser.KW_BOOL, 0); }
		public TerminalNode KW_NUMBER() { return getToken(SPLParser.KW_NUMBER, 0); }
		public TerminalNode KW_STRING() { return getToken(SPLParser.KW_STRING, 0); }
		public TerminalNode KW_LIST() { return getToken(SPLParser.KW_LIST, 0); }
		public TerminalNode KW_FUNC() { return getToken(SPLParser.KW_FUNC, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64512L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_TRUE:
			case KW_FALSE:
			case KW_FUNC:
			case SUB:
			case NOT:
			case LPAREN:
			case LSQUARE:
			case STRING:
			case NUMBER:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				exprStmt();
				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				ifStmt();
				}
				break;
			case KW_PRINT:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				printStmt();
				}
				break;
			case KW_RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				returnStmt();
				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				whileStmt();
				}
				break;
			case LCURLY:
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SPLParser.SEMICOLON, 0); }
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			expression();
			setState(78);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	 
		public IfStmtContext() { }
		public void copyFrom(IfStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseStatementContext extends IfStmtContext {
		public TerminalNode KW_IF() { return getToken(SPLParser.KW_IF, 0); }
		public TerminalNode LPAREN() { return getToken(SPLParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SPLParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(SPLParser.KW_ELSE, 0); }
		public IfElseStatementContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterIfElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitIfElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitIfElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleIfStatementContext extends IfStmtContext {
		public TerminalNode KW_IF() { return getToken(SPLParser.KW_IF, 0); }
		public TerminalNode LPAREN() { return getToken(SPLParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SPLParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SimpleIfStatementContext(IfStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterSimpleIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitSimpleIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitSimpleIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStmt);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new IfElseStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(KW_IF);
				setState(81);
				match(LPAREN);
				setState(82);
				expression();
				setState(83);
				match(RPAREN);
				setState(84);
				statement();
				setState(85);
				match(KW_ELSE);
				setState(86);
				statement();
				}
				break;
			case 2:
				_localctx = new SimpleIfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(KW_IF);
				setState(89);
				match(LPAREN);
				setState(90);
				expression();
				setState(91);
				match(RPAREN);
				setState(92);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends ParserRuleContext {
		public TerminalNode KW_PRINT() { return getToken(SPLParser.KW_PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(SPLParser.SEMICOLON, 0); }
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterPrintStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitPrintStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitPrintStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_printStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(KW_PRINT);
			setState(97);
			expression();
			setState(98);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode KW_RETURN() { return getToken(SPLParser.KW_RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SPLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(KW_RETURN);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3866611942412L) != 0)) {
				{
				setState(101);
				expression();
				}
			}

			setState(104);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode KW_WHILE() { return getToken(SPLParser.KW_WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(SPLParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SPLParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(KW_WHILE);
			setState(107);
			match(LPAREN);
			setState(108);
			expression();
			setState(109);
			match(RPAREN);
			setState(110);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(SPLParser.LCURLY, 0); }
		public DeclartionListContext declartionList() {
			return getRuleContext(DeclartionListContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(SPLParser.RCURLY, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(LCURLY);
			setState(113);
			declartionList();
			setState(114);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			assignment();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SPLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SPLParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3866611942412L) != 0)) {
				{
				setState(118);
				expression();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(119);
					match(COMMA);
					setState(120);
					expression();
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierAssignContext extends AssignmentContext {
		public TerminalNode IDENTIFIER() { return getToken(SPLParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(SPLParser.ASSIGN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IdentifierAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterIdentifierAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitIdentifierAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitIdentifierAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyAssignContext extends AssignmentContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public EmptyAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterEmptyAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitEmptyAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitEmptyAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignment);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new IdentifierAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(IDENTIFIER);
				setState(129);
				match(ASSIGN);
				setState(130);
				assignment();
				}
				break;
			case 2:
				_localctx = new EmptyAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				term(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryTermContext extends TermContext {
		public Token op;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode NOT() { return getToken(SPLParser.NOT, 0); }
		public TerminalNode SUB() { return getToken(SPLParser.SUB, 0); }
		public UnaryTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterUnaryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitUnaryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitUnaryTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubTermContext extends TermContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode ADD() { return getToken(SPLParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SPLParser.SUB, 0); }
		public AddSubTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterAddSubTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitAddSubTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitAddSubTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryTermContext extends TermContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterPrimaryTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitPrimaryTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitPrimaryTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode OR() { return getToken(SPLParser.OR, 0); }
		public OrTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterOrTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitOrTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitOrTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallTermContext extends TermContext {
		public ExpressionListContext arguments;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SPLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SPLParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public FunctionCallTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterFunctionCallTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitFunctionCallTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitFunctionCallTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndTermContext extends TermContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode AND() { return getToken(SPLParser.AND, 0); }
		public AndTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterAndTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitAndTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitAndTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivTermContext extends TermContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode MUL() { return getToken(SPLParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(SPLParser.DIV, 0); }
		public MulDivTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterMulDivTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitMulDivTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitMulDivTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonTermContext extends TermContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode GT() { return getToken(SPLParser.GT, 0); }
		public TerminalNode GTE() { return getToken(SPLParser.GTE, 0); }
		public TerminalNode LT() { return getToken(SPLParser.LT, 0); }
		public TerminalNode LTE() { return getToken(SPLParser.LTE, 0); }
		public ComparisonTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterComparisonTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitComparisonTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitComparisonTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityTermContext extends TermContext {
		public Token op;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode NEQ() { return getToken(SPLParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(SPLParser.EQ, 0); }
		public EqualityTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterEqualityTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitEqualityTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitEqualityTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_TRUE:
			case KW_FALSE:
			case KW_FUNC:
			case LPAREN:
			case LSQUARE:
			case STRING:
			case NUMBER:
			case IDENTIFIER:
				{
				_localctx = new PrimaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(135);
				primary();
				}
				break;
			case SUB:
			case NOT:
				{
				_localctx = new UnaryTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				((UnaryTermContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
					((UnaryTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(137);
				term(7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(165);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(163);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(140);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(141);
						((MulDivTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						term(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(143);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(144);
						((AddSubTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(145);
						term(6);
						}
						break;
					case 3:
						{
						_localctx = new ComparisonTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(146);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(147);
						((ComparisonTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
							((ComparisonTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						term(5);
						}
						break;
					case 4:
						{
						_localctx = new EqualityTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(149);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(150);
						((EqualityTermContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==NEQ || _la==EQ) ) {
							((EqualityTermContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(151);
						term(4);
						}
						break;
					case 5:
						{
						_localctx = new AndTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(152);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(153);
						match(AND);
						setState(154);
						term(3);
						}
						break;
					case 6:
						{
						_localctx = new OrTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(155);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(156);
						match(OR);
						setState(157);
						term(2);
						}
						break;
					case 7:
						{
						_localctx = new FunctionCallTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(158);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(159);
						match(LPAREN);
						setState(160);
						((FunctionCallTermContext)_localctx).arguments = expressionList();
						setState(161);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public Token ident;
		public TerminalNode KW_TRUE() { return getToken(SPLParser.KW_TRUE, 0); }
		public TerminalNode KW_FALSE() { return getToken(SPLParser.KW_FALSE, 0); }
		public TerminalNode NUMBER() { return getToken(SPLParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(SPLParser.STRING, 0); }
		public TerminalNode LPAREN() { return getToken(SPLParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SPLParser.RPAREN, 0); }
		public TerminalNode LSQUARE() { return getToken(SPLParser.LSQUARE, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(SPLParser.RSQUARE, 0); }
		public TerminalNode KW_FUNC() { return getToken(SPLParser.KW_FUNC, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SPLParser.IDENTIFIER, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primary);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_TRUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(KW_TRUE);
				}
				break;
			case KW_FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(KW_FALSE);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				match(STRING);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				match(LPAREN);
				setState(173);
				expression();
				setState(174);
				match(RPAREN);
				}
				break;
			case LSQUARE:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				match(LSQUARE);
				setState(177);
				expressionList();
				setState(178);
				match(RSQUARE);
				}
				break;
			case KW_FUNC:
				enterOuterAlt(_localctx, 7);
				{
				setState(180);
				match(KW_FUNC);
				setState(181);
				match(LPAREN);
				setState(182);
				paramList();
				setState(183);
				match(RPAREN);
				setState(184);
				block();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 8);
				{
				setState(186);
				((PrimaryContext)_localctx).ident = match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamListContext extends ParserRuleContext {
		public List<BoundedIdentContext> boundedIdent() {
			return getRuleContexts(BoundedIdentContext.class);
		}
		public BoundedIdentContext boundedIdent(int i) {
			return getRuleContext(BoundedIdentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SPLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SPLParser.COMMA, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPLListener ) ((SPLListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SPLVisitor ) return ((SPLVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(189);
				boundedIdent();
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(190);
					match(COMMA);
					setState(191);
					boundedIdent();
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		case 6:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u00c8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001"+
		",\b\u0001\u0001\u0002\u0005\u0002/\b\u0002\n\u0002\f\u00022\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004B\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006L\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b_\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0003\ng\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000ez\b"+
		"\u000e\n\u000e\f\u000e}\t\u000e\u0003\u000e\u007f\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0085\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u008b\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00a4\b\u0010"+
		"\n\u0010\f\u0010\u00a7\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00bc\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00c1\b\u0012\n\u0012\f\u0012"+
		"\u00c4\t\u0012\u0003\u0012\u00c6\b\u0012\u0001\u0012\u0000\u0001 \u0013"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$\u0000\u0006\u0001\u0000\n\u000f\u0002\u0000\u0013\u0013"+
		"\u001a\u001a\u0001\u0000\u0010\u0011\u0001\u0000\u0012\u0013\u0001\u0000"+
		"\u0015\u0018\u0002\u0000\u0014\u0014\u0019\u0019\u00d3\u0000&\u0001\u0000"+
		"\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000\u0000"+
		"\u0006<\u0001\u0000\u0000\u0000\b>\u0001\u0000\u0000\u0000\nC\u0001\u0000"+
		"\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eM\u0001\u0000\u0000\u0000"+
		"\u0010^\u0001\u0000\u0000\u0000\u0012`\u0001\u0000\u0000\u0000\u0014d"+
		"\u0001\u0000\u0000\u0000\u0016j\u0001\u0000\u0000\u0000\u0018p\u0001\u0000"+
		"\u0000\u0000\u001at\u0001\u0000\u0000\u0000\u001c~\u0001\u0000\u0000\u0000"+
		"\u001e\u0084\u0001\u0000\u0000\u0000 \u008a\u0001\u0000\u0000\u0000\""+
		"\u00bb\u0001\u0000\u0000\u0000$\u00c5\u0001\u0000\u0000\u0000&\'\u0003"+
		"\u0004\u0002\u0000\'(\u0005\u0000\u0000\u0001(\u0001\u0001\u0000\u0000"+
		"\u0000),\u0003\u0006\u0003\u0000*,\u0003\f\u0006\u0000+)\u0001\u0000\u0000"+
		"\u0000+*\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-/\u0003"+
		"\u0002\u0001\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u0000"+
		"0.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0005\u0001\u0000"+
		"\u0000\u000020\u0001\u0000\u0000\u000034\u0005\u0004\u0000\u000045\u0003"+
		"\b\u0004\u000056\u0005\u001d\u0000\u000067\u0003\u001a\r\u000078\u0005"+
		"$\u0000\u00008=\u0001\u0000\u0000\u00009:\u0005\u0004\u0000\u0000:;\u0005"+
		")\u0000\u0000;=\u0005$\u0000\u0000<3\u0001\u0000\u0000\u0000<9\u0001\u0000"+
		"\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>A\u0005)\u0000\u0000?@\u0005"+
		"%\u0000\u0000@B\u0003\n\u0005\u0000A?\u0001\u0000\u0000\u0000AB\u0001"+
		"\u0000\u0000\u0000B\t\u0001\u0000\u0000\u0000CD\u0007\u0000\u0000\u0000"+
		"D\u000b\u0001\u0000\u0000\u0000EL\u0003\u000e\u0007\u0000FL\u0003\u0010"+
		"\b\u0000GL\u0003\u0012\t\u0000HL\u0003\u0014\n\u0000IL\u0003\u0016\u000b"+
		"\u0000JL\u0003\u0018\f\u0000KE\u0001\u0000\u0000\u0000KF\u0001\u0000\u0000"+
		"\u0000KG\u0001\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000KJ\u0001\u0000\u0000\u0000L\r\u0001\u0000\u0000\u0000MN\u0003"+
		"\u001a\r\u0000NO\u0005$\u0000\u0000O\u000f\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u0006\u0000\u0000QR\u0005\u001e\u0000\u0000RS\u0003\u001a\r\u0000ST\u0005"+
		"\u001f\u0000\u0000TU\u0003\f\u0006\u0000UV\u0005\u0007\u0000\u0000VW\u0003"+
		"\f\u0006\u0000W_\u0001\u0000\u0000\u0000XY\u0005\u0006\u0000\u0000YZ\u0005"+
		"\u001e\u0000\u0000Z[\u0003\u001a\r\u0000[\\\u0005\u001f\u0000\u0000\\"+
		"]\u0003\f\u0006\u0000]_\u0001\u0000\u0000\u0000^P\u0001\u0000\u0000\u0000"+
		"^X\u0001\u0000\u0000\u0000_\u0011\u0001\u0000\u0000\u0000`a\u0005\u0005"+
		"\u0000\u0000ab\u0003\u001a\r\u0000bc\u0005$\u0000\u0000c\u0013\u0001\u0000"+
		"\u0000\u0000df\u0005\t\u0000\u0000eg\u0003\u001a\r\u0000fe\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0005"+
		"$\u0000\u0000i\u0015\u0001\u0000\u0000\u0000jk\u0005\b\u0000\u0000kl\u0005"+
		"\u001e\u0000\u0000lm\u0003\u001a\r\u0000mn\u0005\u001f\u0000\u0000no\u0003"+
		"\f\u0006\u0000o\u0017\u0001\u0000\u0000\u0000pq\u0005 \u0000\u0000qr\u0003"+
		"\u0004\u0002\u0000rs\u0005!\u0000\u0000s\u0019\u0001\u0000\u0000\u0000"+
		"tu\u0003\u001e\u000f\u0000u\u001b\u0001\u0000\u0000\u0000v{\u0003\u001a"+
		"\r\u0000wx\u0005&\u0000\u0000xz\u0003\u001a\r\u0000yw\u0001\u0000\u0000"+
		"\u0000z}\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"~v\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u001d"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0005)\u0000\u0000\u0081\u0082\u0005"+
		"\u001d\u0000\u0000\u0082\u0085\u0003\u001e\u000f\u0000\u0083\u0085\u0003"+
		" \u0010\u0000\u0084\u0080\u0001\u0000\u0000\u0000\u0084\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u001f\u0001\u0000\u0000\u0000\u0086\u0087\u0006\u0010"+
		"\uffff\uffff\u0000\u0087\u008b\u0003\"\u0011\u0000\u0088\u0089\u0007\u0001"+
		"\u0000\u0000\u0089\u008b\u0003 \u0010\u0007\u008a\u0086\u0001\u0000\u0000"+
		"\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u00a5\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\n\u0006\u0000\u0000\u008d\u008e\u0007\u0002\u0000\u0000"+
		"\u008e\u00a4\u0003 \u0010\u0007\u008f\u0090\n\u0005\u0000\u0000\u0090"+
		"\u0091\u0007\u0003\u0000\u0000\u0091\u00a4\u0003 \u0010\u0006\u0092\u0093"+
		"\n\u0004\u0000\u0000\u0093\u0094\u0007\u0004\u0000\u0000\u0094\u00a4\u0003"+
		" \u0010\u0005\u0095\u0096\n\u0003\u0000\u0000\u0096\u0097\u0007\u0005"+
		"\u0000\u0000\u0097\u00a4\u0003 \u0010\u0004\u0098\u0099\n\u0002\u0000"+
		"\u0000\u0099\u009a\u0005\u001b\u0000\u0000\u009a\u00a4\u0003 \u0010\u0003"+
		"\u009b\u009c\n\u0001\u0000\u0000\u009c\u009d\u0005\u001c\u0000\u0000\u009d"+
		"\u00a4\u0003 \u0010\u0002\u009e\u009f\n\b\u0000\u0000\u009f\u00a0\u0005"+
		"\u001e\u0000\u0000\u00a0\u00a1\u0003\u001c\u000e\u0000\u00a1\u00a2\u0005"+
		"\u001f\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u008c\u0001"+
		"\u0000\u0000\u0000\u00a3\u008f\u0001\u0000\u0000\u0000\u00a3\u0092\u0001"+
		"\u0000\u0000\u0000\u00a3\u0095\u0001\u0000\u0000\u0000\u00a3\u0098\u0001"+
		"\u0000\u0000\u0000\u00a3\u009b\u0001\u0000\u0000\u0000\u00a3\u009e\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6!\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00bc\u0005\u0002"+
		"\u0000\u0000\u00a9\u00bc\u0005\u0003\u0000\u0000\u00aa\u00bc\u0005(\u0000"+
		"\u0000\u00ab\u00bc\u0005\'\u0000\u0000\u00ac\u00ad\u0005\u001e\u0000\u0000"+
		"\u00ad\u00ae\u0003\u001a\r\u0000\u00ae\u00af\u0005\u001f\u0000\u0000\u00af"+
		"\u00bc\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\"\u0000\u0000\u00b1\u00b2"+
		"\u0003\u001c\u000e\u0000\u00b2\u00b3\u0005#\u0000\u0000\u00b3\u00bc\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0005\n\u0000\u0000\u00b5\u00b6\u0005\u001e"+
		"\u0000\u0000\u00b6\u00b7\u0003$\u0012\u0000\u00b7\u00b8\u0005\u001f\u0000"+
		"\u0000\u00b8\u00b9\u0003\u0018\f\u0000\u00b9\u00bc\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bc\u0005)\u0000\u0000\u00bb\u00a8\u0001\u0000\u0000\u0000\u00bb"+
		"\u00a9\u0001\u0000\u0000\u0000\u00bb\u00aa\u0001\u0000\u0000\u0000\u00bb"+
		"\u00ab\u0001\u0000\u0000\u0000\u00bb\u00ac\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b0\u0001\u0000\u0000\u0000\u00bb\u00b4\u0001\u0000\u0000\u0000\u00bb"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bc#\u0001\u0000\u0000\u0000\u00bd\u00c2"+
		"\u0003\b\u0004\u0000\u00be\u00bf\u0005&\u0000\u0000\u00bf\u00c1\u0003"+
		"\b\u0004\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c5\u00bd\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c6%\u0001\u0000\u0000\u0000\u0010+0<AK^f{~\u0084\u008a"+
		"\u00a3\u00a5\u00bb\u00c2\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}