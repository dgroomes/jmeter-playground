# jmeter-playground

📚 Learning and exploring Apache JMeter <https://jmeter.apache.org>.

## Standalone sub-projects

This repository illustrates different concepts, patterns and examples via standalone sub-projects. Each sub-project is
completely independent of the others and do not depend on the root project. This _standalone sub-project constraint_
forces the sub-projects to be complete and maximizes the reader's chances of successfully running, understanding, and
re-using the code.

The sub-projects include:

### `custom-sampler/`

This sub-project creates a custom JMeter "Sampler" to exercise some custom Java code.

See the README in [custom-sampler/](custom-sampler/).

## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* Split the Jackson library example out of `custom-sampler/` into its own sub-project `with-dependencies/`

## Referenced Materials

* [Apache JMeter: Apache project page](https://jmeter.apache.org)
* [Apache JMeter: GitHub repo](https://github.com/apache/jmeter)
