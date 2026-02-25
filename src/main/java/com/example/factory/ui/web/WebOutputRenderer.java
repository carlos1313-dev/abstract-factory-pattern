/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.web;

import com.example.factory.adapter.output.OutputAdapter;
import com.example.factory.adapter.output.ResultToIntAdapter;
import com.example.factory.adapter.output.ResultToStringAdapter;
import com.example.factory.model.CalculationResult;
import com.example.factory.ui.Output;

/**
 * @author dev.nicolasruin & sangr
 * Web output renderer.
 * Uses the SAME shared output adapters as Console and Swing.
 *
 * render() stores the result internally; the controller then calls
 * getFormattedString() or getTruncatedInt() to build the HTTP response.
 */
public class WebOutputRenderer implements Output {

    // Shared adapters — same ones used by Console and Swing
    private final OutputAdapter<String>  stringAdapter = new ResultToStringAdapter();
    private final OutputAdapter<Integer> intAdapter    = new ResultToIntAdapter();

    private CalculationResult lastResult;

    @Override
    public void render(CalculationResult result) {
        this.lastResult = result;
    }

    /** e.g. "ADD: 8.0" */
    public String getFormattedString() {
        if (lastResult == null) throw new IllegalStateException("No result rendered yet.");
        return stringAdapter.adapt(lastResult);
    }

    /** e.g. 8  (truncates decimals) */
    public int getTruncatedInt() {
        if (lastResult == null) throw new IllegalStateException("No result rendered yet.");
        return intAdapter.adapt(lastResult);
    }

    /** Raw result, kept for backwards compatibility. */
    public CalculationResult getLastResult() {
        return lastResult;
    }
}
