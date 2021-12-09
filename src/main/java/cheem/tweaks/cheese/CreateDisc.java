package cheem.tweaks.cheese;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;

public class CreateDisc extends MusicDiscItem{
    public CreateDisc(int comparatorOutput, SoundEvent sound, Settings settings) {
        super(comparatorOutput, sound, settings);
    }
}
