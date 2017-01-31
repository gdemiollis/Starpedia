package fr.and1droid.starpedia.injection;

import fr.and1droid.starpedia.ListActivity;

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

    static final class Graph {

        private final MainComponent mainComponent;

        private Graph() {
            mainComponent = DaggerMainComponent.builder()
                    .serviceModule(new ServiceModule())
                    .build();
        }
    }
}