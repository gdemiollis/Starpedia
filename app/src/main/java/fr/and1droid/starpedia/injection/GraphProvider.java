package fr.and1droid.starpedia.injection;

import fr.and1droid.starpedia.service.ServiceFactory;
import fr.and1droid.starpedia.ui.detail.DetailActivity;
import fr.and1droid.starpedia.ui.list.EntityRecyclerViewAdapter;
import fr.and1droid.starpedia.ui.list.ListActivity;

public final class GraphProvider {

    private static Graph graph;

    private GraphProvider() {
    }

    public static void init() {
        graph = new Graph();
    }

    public static void injectIn(final ListActivity target) {
        if (graph != null) {
            graph.mainComponent.inject(target);
        }
    }

    public static void injectIn(ServiceFactory target) {
        if (graph != null) {
            graph.mainComponent.inject(target);
        }
    }

    public static void injectIn(EntityRecyclerViewAdapter target) {
        if (graph != null) {
            graph.mainComponent.inject(target);
        }
    }

    public static void injectIn(DetailActivity target) {
        if (graph != null) {
            graph.mainComponent.inject(target);
        }
    }

    static final class Graph {

        private final MainComponent mainComponent;

        private Graph() {
            mainComponent = DaggerMainComponent.builder()
                    .serviceModule(new ServiceModule())
                    .build();
        }
    }
}