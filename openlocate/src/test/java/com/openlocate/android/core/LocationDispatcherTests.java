/*
 * Copyright (c) 2017 OpenLocate
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.openlocate.android.core;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocationDispatcherTests {

//    @Test
//    public void testSuccessLocationDispatch() {
//        final Object syncObject = new Object();
//
//        final LocationDataSource dataSource = new LocationList();
//
//        HttpClient successClient = new HttpClient() {
//            @Override
//            public void post(String url, String json, Map<String, String> additionalHeaders, HttpClientCallback successCallback, HttpClientCallback failureCallback) {
//                HttpResponse response = new HttpResponse.Builder().setStatusCode(200).build();
//                successCallback.onCompletion(null, response);
//
//                assertEquals(0, dataSource.size());
//
//                synchronized (syncObject) {
//                    syncObject.notify();
//                }
//            }
//        };
//
//        LocationDispatcher dispatcher = new LocationDispatcher();
//        dispatcher.postLocations(successClient, "", null, dataSource);
//
//        // Then
//        synchronized (syncObject) {
//            try {
//                syncObject.wait();
//            } catch (InterruptedException e) {
//                assertTrue(false);
//            }
//        }
//    }
//
//    @Test
//    public void testFailureLocationDispatch() {
//        final Object syncObject = new Object();
//
//        final LocationDataSource dataSource = new LocationList();
//
//        HttpClient failureClient = new HttpClient() {
//            @Override
//            public void post(String url, String json, Map<String, String> additionalHeaders, HttpClientCallback successCallback, HttpClientCallback failureCallback) {
//                HttpResponse response = new HttpResponse.Builder().setStatusCode(400).build();
//                successCallback.onCompletion(null, response);
//
//                assertEquals(1, dataSource.size());
//
//                synchronized (syncObject) {
//                    syncObject.notify();
//                }
//            }
//        };
//
//        LocationDispatcher dispatcher = new LocationDispatcher();
//        dispatcher.postLocations(failureClient, "", null, dataSource);
//
//        // Then
//        synchronized (syncObject) {
//            try {
//                syncObject.wait();
//            } catch (InterruptedException e) {
//                assertTrue(false);
//            }
//        }
//    }
}
