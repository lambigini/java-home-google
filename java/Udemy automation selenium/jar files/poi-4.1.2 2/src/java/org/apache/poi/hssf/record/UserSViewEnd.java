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

import java.util.Locale;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.Removal;

/**
 * The UserSViewEnd record marks the end of the settings for a custom view associated with the sheet
 */
public final class UserSViewEnd extends StandardRecord {

    public static final short sid = 0x01AB;
	private byte[] _rawData;

    public UserSViewEnd(UserSViewEnd other) {
        super(other);
        _rawData = (other._rawData == null) ? null : other._rawData.clone();
    }

    public UserSViewEnd(byte[] data) {
        _rawData = data;
    }

	/**
	 * construct an UserSViewEnd record.  No fields are interpreted and the record will
	 * be serialized in its original form more or less
	 * @param in the RecordInputstream to read the record from
	 */
	public UserSViewEnd(RecordInputStream in) {
		_rawData = in.readRemainder();
	}

	/**
	 * spit the record out AS IS. no interpretation or identification
	 */
	public void serialize(LittleEndianOutput out) {
		out.write(_rawData);
	}

	protected int getDataSize() {
		return _rawData.length;
	}

    public short getSid()
    {
        return sid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('[').append("USERSVIEWEND").append("] (0x");
        sb.append(Integer.toHexString(sid).toUpperCase(Locale.ROOT)).append(")\n");
        sb.append("  rawData=").append(HexDump.toHex(_rawData)).append("\n");
        sb.append("[/").append("USERSVIEWEND").append("]\n");
        return sb.toString();
    }

    @Override
    @SuppressWarnings("squid:S2975")
    @Deprecated
    @Removal(version = "5.0.0")
    public UserSViewEnd clone() {
        return copy();
    }

    @Override
    public UserSViewEnd copy() {
        return new UserSViewEnd(this);
    }
}
