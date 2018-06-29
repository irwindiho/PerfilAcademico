package com.irvinmarin.apps.miperfilacademico.database;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by irvinmarin on 10/05/2018.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    public static final String NAME = "Perfil";
    public static final int VERSION = 1;
}
