package plugin.search;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.SearchPlugin;

import java.util.Collections;
import java.util.List;

public class MultiMatchPlugin extends Plugin implements SearchPlugin {

    @Override
    public List<QuerySpec<?>> getQueries() {
        return Collections.singletonList(
                new QuerySpec<QueryBuilder>(
                        "multi_match_plugin",
                        MultiMatchQueryPluginBuilder::new,
                        MultiMatchQueryPluginBuilder::fromXContent
                )
        );
    }
}