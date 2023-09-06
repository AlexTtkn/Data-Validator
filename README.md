### Hexlet tests and linter status:
[![Actions Status](https://github.com/AlexTtkn/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/AlexTtkn/java-project-78/actions)
[![Java CI](https://github.com/AlexTtkn/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/AlexTtkn/java-project-78/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/6cf4a4fbb1f277b8c91b/maintainability)](https://codeclimate.com/github/AlexTtkn/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/6cf4a4fbb1f277b8c91b/test_coverage)](https://codeclimate.com/github/AlexTtkn/java-project-78/test_coverage)

## Description:
A data validator is a library that enables the verification of the correctness of any data. 
There are numerous such libraries available in each programming language, as almost all programs 
work with external data that needs to be checked for accuracy. Primarily, this concerns data from user-filled forms. 
The project is based on the [yup](https://github.com/jquense/yup) library.

## Examples
```
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// Strings
StringSchema schema = v.string().required();

schema.isValid("this is string for test"); // true
schema.isValid(""); // false

// Numbers
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// Map object with structure checking support
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Alex");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
```
