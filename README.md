# End's Delight Legacy

End exploration and cooking for **Minecraft Forge 1.7.10 and 1.12.2**, requiring **Farmer's Delight Legacy 1.0.2+** and its normal Mixin bootstrap.

The native ports preserve the original End ingredients, 37 food definitions, four knife materials, seven blocks, feast serving, and six-slot End Stove. FD's Cutting Board, Cooking Pot, furnace/grilling paths, knife behavior, inventory persistence and serving systems remain authoritative. Use knives for the original End mob drops. Chorus foods retain their sneak-triggered or automatic teleport behavior and original food effects where those effects exist natively.

On 1.12.2, find chorus succulent on outer End islands, plant it on solid ground, stack up to three plants and use bonemeal on End stone to grow a full cluster. Native shulkers and endermites supply their original knife-qualified ingredients. The old target has no corresponding mobs or outer-island resource path, so those recipe chains remain deferred instead of adding replacement mobs or relocating modern resources onto the main island.

Missing original requirements (including campfires, modern End resources on 1.7.10, and unsupported Farmer's Respite brewing) stay deferred for their actual providers, including future UAB integration where applicable. The End Stove's original campfire-based crafting recipe is therefore deferred on both targets. Creative registration does not enable unreachable recipes. The original End's Delight non-hatchable egg recipe still requires End crystals and dragon tooth; its requirements are not replaced. No unrelated End overhaul is included.

`config/ends_delight.cfg` controls original knife mob drops and 1.12.2 outer-island succulent generation, with a default patch interval of eight chunks. Generation is bounded to the current chunk. Minecraft 1.7.10 has no native Levitation effect or per-item cooldown API; unavailable shulker recipe chains are deferred, and existing vanilla effects keep their native behavior.

## Build

Build the adjacent Farmer's Delight Legacy checkout first. Use JDK 21 for the coordinator/1.12.2 and JDK 25 for the existing GTNH 1.7.10 toolchain; game runtime is Java 8. Run `gradlew.bat buildAll`. Development FD JARs are compile-only and are never bundled.

Native source is in `versions/<minecraft>/src/`; source-derived content data is in `common/`; the original modern source/assets remain under `src/`, with their original build configuration preserved under `reference/`. Original recipes, tags, models, textures and names are converted at build time. Shared FD pie geometry retains its MIT license notice in the archive.

Distributions: `build/release/ends_delight-1.0.0+mc1.7.10.jar` and `ends_delight-1.0.0+mc1.12.2.jar`.

Original mod by FoggyHillside, with credits to PExPE3 and SKZGx. Original source and assets retain the included MIT license.
