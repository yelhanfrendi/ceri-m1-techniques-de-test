package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokedex pokedex;
    List<Pokemon> listePokemon = new ArrayList();


    @Before
    public void init() throws PokedexException {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
    }

    @Test
    public void getSize() {
        assertEquals(2, pokedex.size());
    }


    @Test
    public void addPokemon() {
        Pokemon pokemon2 = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokedex.addPokemon(pokemon2);
        assertEquals(3, pokedex.size());
    }

    @Test
    public void getPokemon() throws PokedexException {
        Pokemon result = pokedex.getPokemon(0);
        assertEquals(0, result.getIndex());
    }

    @Test
    public void getPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
    }

    @Test
    public void getPokemons2() {
        PokemonComparators pokemonComparator = PokemonComparators.INDEX;
        List<Pokemon> pokemons = pokedex.getPokemons(pokemonComparator);
        assertEquals(2, pokemons.size());
        assertEquals(0, pokemons.get(0).getIndex());
        assertEquals(133, pokemons.get(1).getIndex());
    }
}