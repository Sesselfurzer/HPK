package de.lab4inf.wrb;
/*
 * Copyright (c) 2012-2017 The ANTLR Project. All rights reserved.
 * Use of this file is governed by the BSD 3-clause license that
 * can be found in the LICENSE.txt file in the project root.
 */
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
/**
 *
 * @author Sam Harwell changed by Marvin Schneider/Jannek Siegbert
 */
public class WRBConsoleErrorListener extends BaseErrorListener {
	/**
	 * Provides a default instance of {@link ConsoleErrorListener}.
	 */
	public static final WRBConsoleErrorListener INSTANCE = new WRBConsoleErrorListener();

	/**
	 * {@inheritDoc}
	 *
	 * <p>
	 * This implementation prints messages to {@link System#err} containing the
	 * values of {@code line}, {@code charPositionInLine}, and {@code msg} using
	 * the following format.</p>
	 *
	 * <pre>
	 * line <em>line</em>:<em>charPositionInLine</em> <em>msg</em>
	 * </pre>
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
							Object offendingSymbol,
							int line,
							int charPositionInLine,
							String msg,
							RecognitionException e)
		throws IllegalArgumentException {
	         throw new IllegalArgumentException("line " + line + ":" + charPositionInLine + " " + msg);
	      }

}
