import jinja2
import re

input_name = input('请输入主体名，如 TestTableDO, TestTableService 等主体就是 TestTable: ')


def pascal_case_to_snake_case(camel_case: str):
    """大驼峰（帕斯卡）转蛇形"""
    snake_case = re.sub(r"(?P<key>[A-Z])", r"_\g<key>", camel_case)
    return snake_case.lower().strip('_')


def lower_first_letter(word: str):
    return word[0].lower() + word[1:]


jinja2.filters.FILTERS['snake_case'] = pascal_case_to_snake_case
jinja2.filters.FILTERS['lower_first'] = lower_first_letter

base_dir = '../src/main/java/org/corgi/template'


# dto
def gen_dto():
    pass


# transformer
def gen_transformer():
    with open('jinja_templates/transformer.tpl', 'r', encoding='utf8') as f:
        s = jinja2.Template(f.read(), trim_blocks=True).render(name=input_name)
        with open(f'{base_dir}/util/transformer/{input_name}Transformer.java', 'w', encoding='utf8') as t:
            t.write(s)


# service
def gen_service():
    with open('jinja_templates/service.tpl', 'r', encoding='utf8') as f:
        s = jinja2.Template(f.read(), trim_blocks=True).render(name=input_name)
        with open(f'{base_dir}/service/{input_name}Service.java', 'w', encoding='utf8') as t:
            t.write(s)


# service
def gen_controller():
    with open('jinja_templates/controller.tpl', 'r', encoding='utf8') as f:
        s = jinja2.Template(f.read(), trim_blocks=True).render(name=input_name)
        with open(f'{base_dir}/controller/{input_name}Controller.java', 'w', encoding='utf8') as t:
            t.write(s)


if __name__ == '__main__':
    gen_transformer()
    gen_service()
    gen_controller()
