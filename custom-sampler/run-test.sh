#!/usr/bin/env bash
# Run the JMeter load test and once it is finished open the reporting in the browser.
# The script will first delete existing test run output files (i.e. the .jtl file and test report directory) before
# starting the test.

if [[ -f log.jtl ]]; then
  rm log.jtl
fi

if [[ -d test-report ]]; then
  rm -rf test-report
fi

export JVM_ARGS="-Dnashorn.args=--no-deprecation-warning"
jmeter -n -t echo-sampler-test-plan.jmx -l log.jtl -e -o test-report

open test-report/index.html