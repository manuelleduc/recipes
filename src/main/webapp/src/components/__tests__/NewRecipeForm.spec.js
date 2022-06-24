import {describe, it, expect, beforeEach} from 'vitest';
import {setActivePinia, createPinia} from 'pinia';

import {mount} from '@vue/test-utils';
import NewRecipeForm from '../NewRecipeForm.vue';

describe('NewRecipeForm', () => {
  beforeEach(() => {
    // creates a fresh pinia and make it active so it's automatically picked
    // up by any useStore() call without having to pass it to it:
    // `useStore(pinia)`
    setActivePinia(createPinia());
  });
  it('has an empty title', () => {
    const wrapper = mount(NewRecipeForm, {props: {msg: 'Hello Vitest'}});
    expect(wrapper.find('input').value).toBeUndefined()
  });
});
