
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

import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.Removal;

/**
 * Protect embedded object with the lamest "security" ever invented.
 * This record tells "I want to protect my objects" with lame security.
 * It appears in conjunction with the PASSWORD and PROTECT records as well as its scenario protect cousin.
 */

public final class ObjectProtectRecord extends StandardRecord {
    public static final short sid = 0x63;

    private short field_1_protect;

    public ObjectProtectRecord() {}

    public ObjectProtectRecord(ObjectProtectRecord other) {
        super(other);
        field_1_protect = other.field_1_protect;
    }

    public ObjectProtectRecord(RecordInputStream in) {
        field_1_protect = in.readShort();
    }

    /**
     * set whether the sheet is protected or not
     * @param protect whether to protect the sheet or not
     */

    public void setProtect(boolean protect)
    {
        field_1_protect = (short) (protect ? 1 : 0);
    }

    /**
     * get whether the sheet is protected or not
     * @return whether to protect the sheet or not
     */

    public boolean getProtect()
    {
        return (field_1_protect == 1);
    }

    public String toString()
    {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[SCENARIOPROTECT]\n");
        buffer.append("    .protect         = ").append(getProtect())
            .append("\n");
        buffer.append("[/SCENARIOPROTECT]\n");
        return buffer.toString();
    }

    public void serialize(LittleEndianOutput out) {
        out.writeShort(field_1_protect);
    }

    protected int getDataSize() {
        return 2;
    }

    public short getSid()
    {
        return sid;
    }

    @Override
    @SuppressWarnings("squid:S2975")
    @Deprecated
    @Removal(version = "5.0.0")
    public ObjectProtectRecord clone() {
        return copy();
    }

    @Override
    public ObjectProtectRecord copy() {
        return new ObjectProtectRecord(this);
    }
}
