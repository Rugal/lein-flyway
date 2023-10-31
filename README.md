# Leiningen Flyway plugin

[![Clojars Project](https://img.shields.io/clojars/v/al.rug/lein-flyway.svg)](https://clojars.org/al.rug/lein-flyway)

This is an flyway plugin that fits for the latest `flyway-core:9.22.3`.  

Why having another flyway plugin given we already have [lein-flyway](https://github.com/metaphor/lein-flyway)?  Seems like this plugin is inactive.  
Nothing special but get myself familiarize with leiningen [plugin](https://leiningen.org/plugins.html) development, along with playing around flyway-core API.  

## Usage

### add plugin

Put `[flyway "0.0.0"]` into the `:plugins` vector of your `:user` profile or `:plugins` vector of your project.clj.  

### add flyway configuration

You must prepare your migration file, basically SQL file. Then `edn` format flyway configuration file.  
The actual directory structure does not matter. Below is a demonstration for a simple project.  

```
src
└── ...
resources
└── database
    ├── flyway.edn
    └── migration
        ├── V1__Base_Line.sql
        └── V999__Sample_Data.sql
```

A sample `flyway.edn` can be found [here](sample/resources/database/flyway.edn). Instead of having the ability to configure flyway in `project.clj`, this plugin is designed to offload it to one single flyway configuration file.

### add plugin configuration

Add flyway plugin configuration in `project.clj`  

```clojure
{:flyway {:flyway-configuration-path "resources/database/flyway.edn"}}
```

### Run flyway

```shell
lein help flyway    # get all available task
lein flyway [task]  # execute task
```

## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
