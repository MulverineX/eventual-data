# Eventual Data

By: Mulverine

Data Driven Events System based on Advancement Triggers

## Structure
```jsonc
{
    "trigger": "minecraft:trigger_name",

    // base level conditions, ie `item`
    
    "before": { // checks contexts and runs actions *before* event has finished, ie block id is still `minecraft:air` with `minecraft:placed_block`
        "context": {
            "context_name": { // ie `player`
                // predicate condition
            }
        },
        "actions": [
            // list of `action` objects
        ]
    },
    "after": { // checks contexts and runs actions *after* event has finished, ie block id is no longer `minecraft:air` with `minecraft:placed_block`
        "context": {
            "context_name": { // ie `player`
                // predicate condition
            }
        },
        "actions": [
            // list of `action` objects
        ]
    }
}
```

Triggers are then removed from advancements making the syntax as follows
```json
{
  "display": {
    "icon": {
      "item": "minecraft:diamond_pickaxe"
    },
    "title": "Manufacturing I"
  },
  "rewards": {
    "experience": 1000
  },
  "criteria": [
        "placed_factory",
        "placed_filter",
        "collected_sludge"
    ]
}
```

Different `action` types:
```json
{
    "type": "function",
    "function": "baz:blocks/factory/place_multiblock",
    "context": "block"
}
```
Will execute the defined function with the `block` context, which contains dimension & position, while executor and rotation are left default (console and `0.0, 0.0`)
`block` context would be in relevant triggers such as `placed_block` and `broke_block`. 

There would be context for other involved entities as well, such as `parent` and `partner` for breeding, `victim` for hurting, etc

```json
{
    "type": "set_criterion",
    "advancement": "baz:manufacturing_1",
    "criterion": "placed_factory"
}
```
This would add a criterion to the defined advancement for the player

A `loot_table` action type the same as `function` just renamed

## License

This mod is available under Creative Commons 0. Feel free to learn from it and incorporate it in your own projects.
