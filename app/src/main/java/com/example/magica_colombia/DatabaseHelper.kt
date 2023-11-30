package com.example.magica_colombia

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Button



class DatabaseHelper  (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    companion object {
        const val DATABASE_NAME = "historias.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "historias"
        const val COLUMN_ID = "id"
        const val COLUMN_TITULO = "titulo"
        const val COLUMN_CONTENIDO = "contenido"
        const val COLUMN_DEPARTAMENTO = "departamento"
    }


    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$COLUMN_TITULO TEXT, $COLUMN_CONTENIDO TEXT, $COLUMN_DEPARTAMENTO TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertHistoria(titulo: String, contenido: String, departamento: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TITULO, titulo)
        values.put(COLUMN_CONTENIDO, contenido)
        values.put(COLUMN_DEPARTAMENTO, departamento)
        val id = db.insert(TABLE_NAME, null, values)
        db.close()
        return id
    }

    fun updateHistoria(id: Long, titulo: String, contenido: String, departamento: String): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_TITULO, titulo)
        values.put(COLUMN_CONTENIDO, contenido)
        values.put(COLUMN_DEPARTAMENTO, departamento)
        val rowsAffected = db.update(TABLE_NAME, values, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
        return rowsAffected
    }

    fun deleteHistoria(id: Long): Int {
        val db = this.writableDatabase
        val rowsAffected = db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id.toString()))
        db.close()
        return rowsAffected
    }

    fun getAllHistorias(context: DetalleHistoriaActivity): List<Historia> {
        val historias = mutableListOf<Historia>()
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(COLUMN_ID, COLUMN_TITULO, COLUMN_CONTENIDO),
            null, null, null, null, null, null
        )

        while (cursor.moveToNext()) {
            val historia = Historia(
                cursor.getLong(cursor.getColumnIndex(COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(COLUMN_TITULO)),
                cursor.getString(cursor.getColumnIndex(COLUMN_CONTENIDO)),
                createButton(context, "Actualizar") {
                    fun createButton(context: Context, buttonText: String, onClickAction: () -> Unit): Button {
                        val button = Button(context)
                        button.text = buttonText
                        button.setOnClickListener { onClickAction.invoke() }
                        return button
                    }
                },
                createButton(context, "Eliminar") {
                    // lógica de eliminación
                }
            )

            historias.add(historia)
        }

        cursor.close()
        return historias
    }

    fun createButton(context: DetalleHistoriaActivity, buttonText: String, onClickAction: () -> Unit): Button {
        val button = Button(context)
        button.text = buttonText
        button.setOnClickListener { onClickAction.invoke() }
        return button
    }


}

