package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadataProvider() throws PokedexException{
        IPokemonMetadataProvider PokemonMetadataProvidemocker = Mockito.mock(IPokemonMetadataProvider.class);

        String name="ATest";
        int attack = 02;
        int defense = 03;
        int stamina=04;

        when(PokemonMetadataProvidemocker.getPokemonMetadata(01)).thenReturn(new PokemonMetadata(01, "ATest", 02, 03, 04));

        PokemonMetadata pokemonMetadata = new PokemonMetadata(01, "ATest", 02, 03, 04);

        PokemonMetadataProvidemocker.getPokemonMetadata(01);
        assertEquals(name, pokemonMetadata.getName());
        assertEquals(attack, pokemonMetadata.getAttack());
        assertEquals(defense, pokemonMetadata.getDefense());
        assertEquals(stamina, pokemonMetadata.getStamina());

    }


}
