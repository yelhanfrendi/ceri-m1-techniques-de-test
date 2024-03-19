package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {
    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;
    PokemonComparators comparator;
    Pokemon pokemonBul;
    Pokemon pokemonAQ;
    @Before
    public void start() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory();

        this.pokemonBul = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        this.pokemonAQ = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
    }

    @Test
    public void creationPokedex() throws PokedexException {
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        pokedex.addPokemon(pokemonBul);
        pokedex.addPokemon(pokemonAQ);

        Assert.assertEquals(2, pokedex.size());


        Pokemon pokemon1 = pokedex.getPokemon(pokemonBul.getIndex());
        Pokemon pokemon2 = pokedex.getPokemon(pokemonAQ.getIndex());

        Assert.assertEquals(pokemonBul, pokemon1);
        Assert.assertEquals(pokemonAQ, pokemon2);
    }
}
