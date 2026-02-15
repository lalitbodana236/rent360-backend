Use this workflow:

1. Install BOM locally (every time BOM changes):
    mvn -f rent360-build-platform/rent360-dependencies-bom/pom.xml clean install

2. Build any service (it will resolve BOM from local .m2):
    cd identity-access-service
    mvn clean verify

3. If version changes, update in service pom.xml:
    <rent360.bom.version>0.0.1-SNAPSHOT</rent360.bom.version>

4. If Maven still uses old cached metadata:
    mvn -U clean verify
    
You can ignore GitHub Packages for now and continue fully local.


mvn -f rent360-build-platform/rent360-dependencies-bom/pom.xml -DskipTests install; mvn -f rent360-build-platform/rent360-service-parent/pom.xml -DskipTests install

mvn -DskipTests validate

mvn clean verify