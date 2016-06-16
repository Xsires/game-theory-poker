package org.adamsmith.io;

import org.adamsmith.stage1.HandRecord;

import java.io.IOException;

/**
 * @author Adam
 *
 */
public interface ReadBinaryData {
	public void close() throws IOException ;
	public HandRecord readRecord() throws IOException ;
}
