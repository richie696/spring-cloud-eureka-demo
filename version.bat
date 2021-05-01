@echo -----------------------------------------------------------------------------
@echo Update Version
@echo -----------------------------------------------------------------------------
mvn versions:set -DoldVersion=* -DnewVersion=3.0.0-RELEASE -DprocessAllModules=true -DallowSnapshots=true -DgenerateBackupPoms=false
mvn versions:commit
@pause
