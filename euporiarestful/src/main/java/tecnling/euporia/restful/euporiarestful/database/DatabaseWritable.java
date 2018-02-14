package tecnling.euporia.restful.euporiarestful.database;

/**
 * Implemented by those DAOs for which this app is allowed to write
 * on the DB.
 *
 * @author alessio
 */
interface DatabaseWritable {
    boolean write();
}
