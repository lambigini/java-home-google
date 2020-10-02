
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
 * I have no idea what a Scenario is or why on would want to protect it with the lamest "security" ever invented.
 * However this record tells excel "I want to protect my scenarios" (0xAF) with lame security.
 * It appears in conjunction with the PASSWORD and PROTECT records as well as its object protect cousin.
 */
public final class ScenarioProtectRecord extends StandardRecord {
    public static final short sid = 0xdd;
    private short field_1_protect;

    public ScenarioProtectRecord() {}

    public ScenarioProtectRecord(ScenarioProtectRecord other) {
        super(other);
        field_1_protect = other.field_1_protect;
    }

    public ScenarioProtectRecord(RecordInputStream in) {
        field_1_protect = in.readShort();
    }

    /**
     * set whether the sheet is protected or not
     * @param protect whether to protect the sheet or not
     */

    public void setProtect(boolean protect)
    {
        if (protect)
        {
            field_1_protect = 1;
        }
        else
        {
            field_1_protect = 0;
        }
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
    public ScenarioProtectRecord clone() {
        return copy();
    }

    public ScenarioProtectRecord copy() {
        return new ScenarioProtectRecord(this);
    }
}
