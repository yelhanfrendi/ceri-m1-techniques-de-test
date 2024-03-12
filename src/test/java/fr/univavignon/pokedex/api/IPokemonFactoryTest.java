package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;
    private int index = 0;
    private int cp = 500;
    private int hp = 100;
    private int dust = 2500;
    private int candy = 3;
    private double iv = 56.5;

    @Before
    public void setUp() {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy))
                .thenReturn(new Pokemon(index, "Btest", 50, 50, 50, cp, hp, dust, candy, iv));
    }

    @Test
    public void testgetPockemonFactory() throws PokedexException{
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertEquals("Btest", pokemon.getName());
        assertEquals(50, pokemon.getAttack());
        assertEquals(50, pokemon.getDefense());
        assertEquals(50, pokemon.getStamina());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
        assertEquals(iv, pokemon.getIv(), 0.001);

    }


}
