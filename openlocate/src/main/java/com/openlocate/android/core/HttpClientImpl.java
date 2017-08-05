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

import java.util.concurrent.ExecutionException;

final class HttpClientImpl implements HttpClient {

    private static final String TAG = HttpClientImpl.class.getSimpleName();
    private final String baseUrl;

    HttpClientImpl(String url) {
        baseUrl = url;
    }

    @Override
    public void get(String api, HttpClientCallback successCallback, HttpClientCallback failureCallback) {
        HttpRequest request = new HttpRequest.Builder()
                .setUrl(baseUrl + api)
                .setMethodType(RestClientMethodType.GET)
                .setSuccessCallback(successCallback)
                .setFailureCallback(failureCallback)
                .build();

        execute(request);
    }

    @Override
    public void post(String api, String jsonString, HttpClientCallback successCallback, HttpClientCallback failureCallback) {
        HttpRequest request = new HttpRequest.Builder()
                .setUrl(baseUrl + api)
                .setMethodType(RestClientMethodType.POST)
                .setParams(jsonString)
                .setSuccessCallback(successCallback)
                .setFailureCallback(failureCallback)
                .build();

        execute(request);
    }

    private void execute(HttpRequest request) {
        HttpTask httpTask = new HttpTask();

        try {
            HttpResponse response = httpTask.execute(request).get();
            if (response.isSuccess()) {
                request.getSuccessCallback().onCompletion(
                        request,
                        response
                );
            } else {
                request.getFailureCallback().onCompletion(
                        request,
                        response
                );
            }
        } catch (ExecutionException exception) {
            HttpResponse response = new HttpResponse.Builder()
                    .setError(new Error(exception.getMessage()))
                    .setStatusCode(500)
                    .build();

            request.getFailureCallback().onCompletion(
                    request,
                    response
            );
        } catch (InterruptedException exception) {
            HttpResponse response = new HttpResponse.Builder()
                    .setError(new Error(exception.getMessage()))
                    .setStatusCode(501)
                    .build();

            request.getFailureCallback().onCompletion(
                    request,
                    response
            );
        }
    }
}
