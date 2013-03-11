/*
 * $Id: RefImage.java,v 1.2 2012/04/11 22:28:20 leonardovc Exp $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.sun.pdfview;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;


/**
 * A BufferedImage subclass that holds a strong reference to its graphics 
 * object.  This means that the graphics will never go away as long as 
 * someone holds a reference to this image, and createGraphics() and
 * getGraphics() can be called multiple times safely, and will always return
 * the same graphics object.
 */
public class RefImage {

    /** a strong reference to the graphics object */
	private Bitmap bi;
    private Canvas g;

    /** Creates a new instance of RefImage */
    public RefImage(int width, int height, Config config) {
    	bi = Bitmap.createBitmap(width, height, config);
    }

    /** 
     * Create a graphics object only if it is currently null, otherwise
     * return the existing graphics object.
     */
    public Canvas createGraphics() {
        if (g == null) {
            g = new Canvas(bi);
        }

        return g;
    }
}
