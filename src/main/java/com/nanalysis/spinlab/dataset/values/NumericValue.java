/*
 * RS2D-data-format: a library for RS2D dataset files.
 * Copyright (C) 2022 - Nanalysis Scientific Corp.
 * -
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.nanalysis.spinlab.dataset.values;


import com.nanalysis.spinlab.dataset.enums.NumberType;
import com.nanalysis.spinlab.dataset.util.DOM;
import org.w3c.dom.Node;

public abstract class NumericValue<T> extends Value<T> {
    /**
     * The number enumeration.
     */
    protected NumberType numberType;

    public NumericValue() {
        // empty
    }

    public NumericValue(Node node) {
        super(node);
        this.numberType = DOM.getEnumContent(node, "numberEnum", NumberType.class, NumberType.Double);
        // value and defaultValue must be done in subclasses for typing
    }

    protected Class<? extends Number> getNumberClass() {
        return numberType != null ? numberType.getNumberClass() : Double.class;
    }

    public NumberType getNumberEnum() {
        return numberType;
    }

    public void setNumberEnum(NumberType numberType) {
        this.numberType = numberType;
    }
}
