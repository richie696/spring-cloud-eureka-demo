echo -----------------------------------------------------------------------------
echo Update Version
echo -----------------------------------------------------------------------------
VERSION="1.0.0-RELEASE"
mvn versions:set -DoldVersion=* -DnewVersion=$VERSION -DprocessAllModules=true -DallowSnapshots=true -DgenerateBackupPoms=false
mvn versions:commit
