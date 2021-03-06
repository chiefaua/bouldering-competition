dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
            pooled = false
            dbCreate = 'validate' // use 'update', 'validate', 'create' or 'create-drop'
            // DB is bound as "bcomp" to cloudbees application "bcomp"
            jndiName = 'java:comp/env/jdbc/bcomp'
            // use this URL instead of jndiName for schema-export
            //url = "jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com/bcomp"
            username = 'bcomp'
            password = '785rhgoiehjtg03t'
        }
    }
}
