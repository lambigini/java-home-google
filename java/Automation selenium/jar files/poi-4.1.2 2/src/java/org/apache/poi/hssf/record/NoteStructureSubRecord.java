/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.Removal;

/**
 * ftNts (0x000D)<p>
 * Represents a NoteStructure sub record.<p>
 *
 * The docs say nothing about it. The length of this record is always 26 bytes.
 */
public final class NoteStructureSubRecord extends SubRecord {
    public static final short sid = 0x0D;
    private static final int ENCODED_SIZE = 22;

    private final byte[] reserved;

    /**
     * Construct a new <code>NoteStructureSubRecord</code> and
     * fill its data with the default values
     */
    public NoteStructureSubRecord() {
        //all we know is that the the length of <code>NoteStructureSubRecord</code> is always 22 bytes
        reserved = new byte[ENCODED_SIZE];
    }

    public NoteStructureSubRecord(NoteStructureSubRecord other) {
        super(other);
        reserved = other.reserved.clone();
    }


    /**
     * Read the record data from the supplied <code>RecordInputStream</code>
     *
     * @param in the input to read from
     * @param size the provided size - must be 22
     */
    public NoteStructureSubRecord(LittleEndianInput in, int size) {
        if (size != ENCODED_SIZE) {
            throw new RecordFormatException("Unexpected size (" + size + ")");
        }
        //just grab the raw data
        byte[] buf = IOUtils.safelyAllocate(size, ENCODED_SIZE);
        in.readFully(buf);
        reserved = buf;
    }

    /**
     * Convert this record to string.
     * Used by BiffViewer and other utilities.
     */
    @Override
    public String toString()
    {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[ftNts ]").append("\n");
        buffer.append("  size     = ").append(getDataSize()).append("\n");
        buffer.append("  reserved = ").append(HexDump.toHex(reserved)).append("\n");
        buffer.append("[/ftNts ]").append("\n");
        return buffer.toString();
    }

    /**
     * Serialize the record data into the supplied array of bytes
     *
     * @param out the stream to serialize into
     */
    @Override
    public void serialize(LittleEndianOutput out) {
        out.writeShort(sid);
        out.writeShort(reserved.length);
        out.write(reserved);
    }

	@Override
    protected int getDataSize() {
        return reserved.length;
    }

    /**
     * @return id of this record.
     */
    public short getSid()
    {
        return sid;
    }

    @Override
    @SuppressWarnings("squid:S2975")
    @Deprecated
    @Removal(version = "5.0.0")
    public NoteStructureSubRecord clone() {
        return copy();
    }

    @Override
    public NoteStructureSubRecord copy() {
        return new NoteStructureSubRecord(this);
    }

}


