# jmeter-playground

📚 Learning and exploring Apache JMeter <https://jmeter.apache.org>.


## Standalone subprojects

This repository illustrates different concepts, patterns and examples via standalone subprojects. Each subproject is
completely independent of the others and do not depend on the root project. This _standalone subproject constraint_
forces the subprojects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The subprojects include:


### `custom-sampler/`

This beginner-friendly subproject creates a custom JMeter "Sampler" to exercise some custom Java code.

See the README in [custom-sampler/](custom-sampler/).


### `with-dependencies/`

This subproject creates a custom JMeter "Sampler" using custom Java code and additional Java library dependencies.

See the README in [with-dependencies/](with-dependencies/).


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [x] DONE Split the Jackson library example out of `custom-sampler/` into its own subproject `with-dependencies/`


## Reference

* [Apache JMeter: Apache project page](https://jmeter.apache.org)
* [Apache JMeter: GitHub repo](https://github.com/apache/jmeter)
