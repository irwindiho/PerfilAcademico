package com.irvinmarin.apps.miperfilacademico.main.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.baoyz.widget.PullRefreshLayout;
import com.irvinmarin.apps.miperfilacademico.R;
import com.irvinmarin.apps.miperfilacademico.cursos_matricula.ui.ContratoCursosFragment;
import com.irvinmarin.apps.miperfilacademico.estado_financiero.EstadoFinancieroFragment;
import com.irvinmarin.apps.miperfilacademico.main.MainPresenter;
import com.irvinmarin.apps.miperfilacademico.main.MainPresenterImpl;
import com.irvinmarin.apps.miperfilacademico.main.MainView;
import com.irvinmarin.apps.miperfilacademico.plan_academico.ui.TabsPlanAcademicoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    MainPresenter presenter;
    @BindView(R.id.content_init)
    LinearLayout contentInit;
    @BindView(R.id.content_main_layout)
    LinearLayout contentMainLayout;
    @BindView(R.id.swipeRefreshLayout)
    PullRefreshLayout swipeRefreshLayout;

    public static void launchNewInstace(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupDrawer();
        setupPresenter();

    }

    private void setupSwipeRefresh() {
        // listen refresh event
        swipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // start refresh
                // refresh complete
                for (int i = 0; i < 100; i++) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });


    }

    private void setupPresenter() {
        presenter = new MainPresenterImpl();
        presenter.setView(this);
        presenter.onCreate();

    }

    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        presenter.navigationItemSelected(item.getItemId());

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void showPlanAcademico() {
        setTitle("Plan Academico");
        fragmentTransaction.replace(R.id.content_main_layout, TabsPlanAcademicoFragment.newIntance(1), "notasCursosFragment");
        fragmentTransaction.commit();

    }

    @Override
    public void showEstadoFinanciero() {
        setTitle("Estado Financiero");
        fragmentTransaction.replace(R.id.content_main_layout, EstadoFinancieroFragment.newIntance(1), "estadoFinancieroFragment");
        fragmentTransaction.commit();
    }

    FragmentTransaction fragmentTransaction;

    @Override
    public void hideInitMessage() {
        contentInit.setVisibility(View.GONE);
    }

    @Override
    public void showMatriculaCursos() {
        setTitle("Cursos Matriculados");
        fragmentTransaction.replace(R.id.content_main_layout, ContratoCursosFragment.newIntance(1), "ContratoCursosFragment");
        fragmentTransaction.commit();
    }

    @Override
    public void showInitMessage() {
        contentInit.setVisibility(View.VISIBLE);
    }


}
