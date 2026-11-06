# Changelog

2026-10-23 16:40 — Introduce native Forge 1.7.10 and 1.12.2 ports

- Preserve all 53 upstream item identities, seven blocks, 37 food definitions, four knife materials, feast serving and six-slot End Stove behavior through Farmer's Delight Legacy 1.0.2.
- Add native knife-qualified dragon, shulker and endermite acquisition where their mobs exist. Preserve actual counts and probability rules and repair the upstream loot-modifier registration gap through native Forge events.
- Adapt chorus succulent generation to native outer End islands on 1.12.2, retain edible planting/stacking and End-stone bonemeal growth, and keep the missing 1.7.10 environment deferred.
- Preserve food effects, original ingredients, serving containers and chorus teleport interactions. Validate addon-owned recipe reachability at startup so missing modern resources and unsupported Farmer's Respite recipes remain deferred for their original providers.
- Keep native source and build targets isolated, retain the original references and MIT attribution, and package independent versioned distributions.

2026-10-23 22:14 — Add optional UAB compatibility on Forge 1.7.10

- Use enabled UAB chorus, purpur, fungi, shells and dragon-breath ingredients in original recipes. Add original knife-qualified shulker/endermite meat drops and bounded succulent patches on UAB outer End islands; retain missing campfire requirements.
- Follow the shared compatibility settings in farmersdelight.cfg, existing addon settings and UAB feature availability. Keep UAB optional and preserve saved registrations and other Minecraft implementations.

2026-11-02 01:08 — Synchronize recipe acquisition and document scripting

- Keep dragon, shulker and endermite recipe roots consistent with the addon drop switch, and native 1.12.2 succulent roots consistent with generation settings. Enabled UAB campfires restore the original End-stove recipe through the shared resolver.
- Document optional native recipe scripting for both supported targets; preserve original item identities, processing and external tea-recipe prerequisites.
