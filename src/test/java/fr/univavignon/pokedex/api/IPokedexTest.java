package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class IPokedexTest {

    private IPokedex pokedex;
    List<Pokemon> listePokemon = new ArrayList<Pokemon>();


    @Before
    public void init() throws PokedexException {
        pokedex = mock(IPokedex.class);
        listePokemon = new ArrayList<>();
        Pokemon pokemon1 = new Pokemon(133, "Aquali", 186, 168, 260, 0, 0, 0, 0, 0);
        Pokemon pokemon2 = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);

        listePokemon.add(pokemon1);
        listePokemon.add(pokemon2);
        doAnswer(invocation -> {
            Pokemon pokemon = invocation.getArgument(0);
            listePokemon.add(pokemon);
            return null;
        }).when(pokedex).addPokemon(any(Pokemon.class));
        when(pokedex.size()).thenAnswer(invocation -> listePokemon.size());
        when(pokedex.getPokemon(133)).thenReturn(pokemon1);
        when(pokedex.getPokemons()).thenReturn(listePokemon);
        when(pokedex.getPokemons(any(Comparator.class))).thenAnswer(invocation -> {
            Comparator<Pokemon> comparator = invocation.getArgument(0);
            return listePokemon.stream().sorted(comparator).collect(Collectors.toList());
        });


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
        Pokemon result = pokedex.getPokemon(133);
        assertEquals(133, result.getIndex());
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

        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(133, pokemons.get(1).getIndex());
    }
}