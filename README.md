# multiproject-multiversion
Example of cross Scala versions dependencies in multi SBT projects.

Demo of `build.sbt` containing the definition of three projects:

- **a:** Can compile into both Scala `2.11` and `2.12`. Contains a `Main` app which invokes a method defined in **b** which yields the Scala version used at runtime.
- **b:** Can compile into both Scala `2.11` and `2.12`. Contains a case object with a method providing the running Scala version.
- **c:** **Only** compiles into Scala `2.11`. As **a**, contains a `Main` app which invokes a method defined in **b** which yields the Scala version used at runtime.

## Usage examples

Both **a** and **c** depend on **b**. **b** Can generate artifacts for both `2.11` and `2.12`, the version we can compile **a** and **c** against will determine which artifact version of **b** to generate and use.

### Running **c** main app (the project is limited to Scala 2.11)

```bash
sbt "project c" "+run"
```

```
From C: B says I am running Scala version 2.11.12
[success] Total time: 3 s, completed Oct 26, 2018 5:49:25 PM
```

### Running **a** main app (can compile into Scala 2.11 and Scala 2.12)

```bash
sbt "project a" "+run" # Compiles and runs both versions
```

```
From A: B says I am running Scala version 2.11.12
[success] Total time: 3 s, completed Oct 26, 2018 5:51:15 PM
From A: B says I am running Scala version 2.12.6
[success] Total time: 3 s, completed Oct 26, 2018 5:51:18 PM
```

It is also possible to select the versions we want to use:

```bash
sbt "project a" "++2.11.12 run"
```

```
From A: B says I am running Scala version 2.11.12
[success] Total time: 1 s, completed Oct 26, 2018 5:53:09 PM
```
