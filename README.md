# FizzBuzz with the Open / Closed principle

## Resources

* Slides: https://docs.google.com/presentation/d/1Wppp5rZk9Zxa8j7yt0hARWD84vI2aaO4ptVFgbO8CXs/edit?usp=sharing
* Freely inspired from https://github.com/mathieucans/ocp-fizzbuzz/
  & https://fr.slideshare.net/xpmatteo/20101125-ocpxpday

## Install & run

_This project is built with gradle, and should not require any manual install (gradle will self install & download
everything)._

1. Clone this repo
    ```
    git clone git@git.soma.salesforce.com:Craftforce/java-ocp.git
    ```
2. Open the project with IntelliJ (New > Project from existing sources)
    * In the wizard, opt-in _"Import project from external model"_ and pick _"gradle"_ in the list
3. Open the Gradle panel in IntelliJ, and click on the double arrows icon. This will download gradle itself and the
   necessary dependencies
4. Open FizzBuzzShould.java (in `src/test`) and run it. Tests should have run properly.

## Branches

* **master**: only the tests are provided
* **lionel-solution**: contains 2 commits, the first solves the basic kata, the second one changes an initial
  requirement

Feel free to add any solution / variant to this repo. Just try to keep this readme up-to-date and the branches rebased.

## Updating master

If in any case, there's something to update in master (typo in readme etc.), please do rebase other "solution" branches.
