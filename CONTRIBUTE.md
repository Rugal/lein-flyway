# HOW TO CONTRIBUTE


## development
For [local development](https://leiningen.org/plugins.html#local-development), having `sample/.lein-classpath`, add source folder in it to avoid installation of plugin back & forth.  

## deploy to clojars


### Setup credential
Setup [authentication](https://codeberg.org/leiningen/leiningen/src/branch/stable/doc/DEPLOY.md#authentication) and use 

Edit `~/.lein/profiles.clj`  

```edn
{:auth {:repository-auth {#"clojars" {:username "xxxxx"
                                      :password "CLOJARS_xxxxxx"}}}}
```

### release

Must ensure that current version is suffix with `-SNAPSHOT` while executing command below:  

```shell
lein release
```
