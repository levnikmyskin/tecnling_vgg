package euporia.tecnling.retoricaweb.database;

/**
 * Implemented by those DAOs for which this app is allowed to write
 * on the DB.
 *
 * @author alessio
 */
interface DatabaseWritable {
    boolean write();
}
