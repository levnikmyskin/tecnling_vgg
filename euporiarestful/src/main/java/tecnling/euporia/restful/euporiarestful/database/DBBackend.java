package tecnling.euporia.restful.euporiarestful.database;


interface DBBackend {

    /**
     * Retrieve a single object from the collection or table, using the specified
     * unique field name and value (for SQL datbases, this should be a primary key). If the two parameters are not unique,
     * the method will return the first instance retrieved nonetheless
     */
    Object retrieveFromDb();

    Object getDatabase();

    Object getCollection();

    /**
     * Utility to change any model field
     * @param fieldName the name of the field that needs to be changed
     * @param oldValue the old value of the field
     * @param newValue the new value for the field
     * @return true if succesfully changed
     */
    boolean changeField(String fieldName, String oldValue, String newValue);
}
