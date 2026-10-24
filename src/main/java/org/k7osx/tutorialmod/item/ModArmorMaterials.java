package org.k7osx.tutorialmod.item;

import java.util.Map;

import org.k7osx.tutorialmod.TutorialMod;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModArmorMaterials {
  public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey
      .createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

  public static final ResourceKey<EquipmentAsset> GARNET_KEY = ResourceKey.create(REGISTRY_KEY,
      Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "garnet"));

  public static final ArmorMaterial GARNET_ARMOR_MATERIAL = new ArmorMaterial(
      750,
      Map.of(
          ArmorType.CHESTPLATE, 4,
          ArmorType.HELMET, 3),
      20,
      SoundEvents.ARMOR_EQUIP_LEATHER,
      0,
      0,
      TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "raw_pink_garnet")),
      GARNET_KEY);

}
